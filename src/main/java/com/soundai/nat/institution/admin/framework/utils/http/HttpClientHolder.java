package com.soundai.nat.institution.admin.framework.utils.http;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

public class HttpClientHolder {

    private static final int CONNECTION_REQUEST_TIMEOUT = 10 * 1000;//从连接池中获取到连接的超时时间
    private static final int CONNECTION_TIMEOUT = 10 * 1000;//创建连接的超时时间
    private static final int SOCKET_TIMEOUT = 10 * 1000;//读数据超时时间：从服务器获取响应数据的超时时间
    private static final long KEEP_ALIVE_TIMEOUT = 60 * 1000L; //连接保持时间
    private static final int MAX_TOTAL = 1000;//连接池最大连接数
    private static final int DEFAULT_MAX_PERROUTE = 100;//路由的默认最大连接
    private static final int RETRY_TIMES = 3;//失败重试次数

    private CloseableHttpClient httpClient;

    private HttpClientHolder() {

        ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();
        //LayeredConnectionSocketFactory sslsf = SSLConnectionSocketFactory.getSocketFactory();
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", plainsf)
                .register("https", sslConnectionSocketFactory())
                .build();
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);
        cm.setMaxTotal(MAX_TOTAL);
        cm.setDefaultMaxPerRoute(DEFAULT_MAX_PERROUTE);

        //连接保持时间
        ConnectionKeepAliveStrategy myStrategy = (response, context) -> {
            // Honor 'keep-alive' header
            HeaderElementIterator it = new BasicHeaderElementIterator(response.headerIterator(HTTP.CONN_KEEP_ALIVE));
            while (it.hasNext()) {
                HeaderElement he = it.nextElement();
                String param = he.getName();
                String value = he.getValue();
                if (value != null && "timeout".equalsIgnoreCase(param)) {
                    try {
                        return Long.parseLong(value) * 1000L;
                    } catch (NumberFormatException ignore) {
                        ignore.printStackTrace();
                    }
                }
            }
            return KEEP_ALIVE_TIMEOUT;
        };

        httpClient = HttpClients.custom()
                .setConnectionManager(cm)
//                .setRetryHandler(new DefaultHttpRequestRetryHandler(RETRY_TIMES, false))
                .setKeepAliveStrategy(myStrategy)
                .setDefaultRequestConfig(requestConfig())
                .build();

    }

    private SSLConnectionSocketFactory sslConnectionSocketFactory() {
        SSLConnectionSocketFactory ssf = null;
        try {
            // 在调用SSL之前需要重写验证方法，取消检测SSL
            X509TrustManager trustManager = new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(X509Certificate[] xcs, String str) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] xcs, String str) {
                }
            };
            SSLContext ctx = SSLContext.getInstance(SSLConnectionSocketFactory.TLS);
            ctx.init(null, new TrustManager[]{trustManager}, null);
            ssf = new SSLConnectionSocketFactory(ctx, NoopHostnameVerifier.INSTANCE);
        } catch (KeyManagementException ex) {
            ex.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return ssf;
    }


    /**
     * 延迟加载
     */
    private static class SingletonHolder {
        private static final HttpClientHolder INSTANCE = new HttpClientHolder();
    }

    public static HttpClientHolder getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static void config(HttpRequestBase httpRequestBase) {
        // 设置Header
        // httpRequestBase.setHeader("UserInfo-Agent", "Mozilla/5.0");
        // httpRequestBase.setHeader("Connection", "close");

        httpRequestBase.setConfig(requestConfig());
    }

    private static RequestConfig requestConfig() {
        // 配置请求的超时设置
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
                .setConnectTimeout(CONNECTION_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .build();
        return requestConfig;
    }

    public CloseableHttpClient getHttpClient() {
        return httpClient;
    }
}

