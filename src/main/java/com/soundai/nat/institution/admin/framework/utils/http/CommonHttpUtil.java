package com.soundai.nat.institution.admin.framework.utils.http;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class CommonHttpUtil {

    final public static Map<String, String> HEADER_JSON;

    static {
        HEADER_JSON = new HashMap<>(4);
        HEADER_JSON.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
    }

    public static String doHttpGet(String url, Map<String, String> headerMap) {
        if (log.isDebugEnabled()) {
            log.debug("nat_institution_log doHttpGet_request_url:{}", url);
        }
        HttpGet httpGet = new HttpGet(url);
        if (Objects.nonNull(headerMap)) {
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                httpGet.addHeader(entry.getKey(), entry.getValue());
            }
        }
        CloseableHttpResponse response = null;
        try {
            response = HttpClientHolder.getInstance().getHttpClient().execute(httpGet);
            String result = EntityUtils.toString(response.getEntity());
            if (log.isDebugEnabled()) {
                log.debug("nat_institution_log doHttpGet_response_info:{}", result);
            }
            return result;
        } catch (Exception e) {
            log.error("nat_institution_log_error", e);
        } finally {
            try {
                response.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static String doHttpPost(String url, Map<String, String> headerMap, String requestBody) {
        if (log.isDebugEnabled()) {
            log.debug("nat_institution_log doHttpPost_request_url:{}", url);
            log.debug("nat_institution_log doHttpPost_requestBody:{}", requestBody);
        }
        HttpPost httpPost = new HttpPost(url);
        if (Objects.nonNull(headerMap)) {
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                httpPost.addHeader(entry.getKey(), entry.getValue());
            }
        }
        CloseableHttpResponse response = null;
        try {
            StringEntity entity = new StringEntity(requestBody, "UTF-8");
            httpPost.setEntity(entity);
            response = HttpClientHolder.getInstance().getHttpClient().execute(httpPost);
            String result = EntityUtils.toString(response.getEntity());
            if (log.isDebugEnabled()) {
                log.debug("nat_institution_log doHttpPost_response_info:{}", result);
            }
            return result;
        } catch (Exception e) {
            log.error("nat_institution_log_error", e);
        } finally {
            try {
                response.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static String doHttpPut(String url, Map<String, String> headerMap, JSONObject requestBody) {
        if (log.isDebugEnabled()) {
            log.debug("nat_institution_log doHttpPut_request_url:{}", url);
            log.debug("nat_institution_log doHttpPut_requestBody:{}", requestBody.toString());
        }
        HttpPut httpPut = new HttpPut(url);
        if (Objects.nonNull(headerMap)) {
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                httpPut.addHeader(entry.getKey(), entry.getValue());
            }
        }
        CloseableHttpResponse response = null;
        try {
            StringEntity entity = new StringEntity(requestBody.toString(), "UTF-8");
            httpPut.setEntity(entity);
            response = HttpClientHolder.getInstance().getHttpClient().execute(httpPut);
            String result = EntityUtils.toString(response.getEntity());
            if (log.isDebugEnabled()) {
                log.debug("nat_institution_log doHttpPut_response_info:{}", result);
            }
            return result;
        } catch (Exception e) {
            log.error("nat_institution_log_error", e);
        } finally {
            try {
                response.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static byte[] doHttpPostByte(String url, Map<String, String> headerMap, String requestBody) {
        if (log.isDebugEnabled()) {
            log.debug("nat_institution_log doHttpPost_request_url:{}", url);
            log.debug("nat_institution_log doHttpPost_requestBody:{}", requestBody);
        }
        HttpPost httpPost = new HttpPost(url);
        if (Objects.nonNull(headerMap)) {
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                httpPost.addHeader(entry.getKey(), entry.getValue());
            }
        }
        CloseableHttpResponse response = null;
        byte[] responseContent = null;
        try {
            StringEntity entity = new StringEntity(requestBody, "UTF-8");
            httpPost.setEntity(entity);
            response = HttpClientHolder.getInstance().getHttpClient().execute(httpPost);
            responseContent = EntityUtils.toByteArray(response.getEntity());
            if (log.isDebugEnabled()) {
                log.debug("nat_institution_log doHttpPost_response_info:{}", requestBody);
            }
            return responseContent;
        } catch (Exception e) {
            log.error("nat_institution_log_error", e);
        } finally {
            try {
                response.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

}
