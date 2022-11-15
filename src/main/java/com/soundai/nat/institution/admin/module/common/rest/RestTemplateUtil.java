package com.soundai.nat.institution.admin.module.common.rest;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


/**
* @Description:  restTemplate封装
* @Author: ailijiang
* @Date:
*/
@Slf4j
@Component
public class RestTemplateUtil {

    @Autowired
    private RestTemplate restTemplate;
    /**
     * 发送POST请求
     * @param url 请求url
     * @param returnType 返回类型,必须重写toString()方法,否则不能正确记录日志信息
     * @return 指定的返回类型
     */
    public <T> T doPostByJson(String url, HttpHeaders headers, Class<T> returnType) {
        return doPostByJson(url, null,headers, returnType);
    }

    /**
     * 发送POST请求
     * @param url 请求url
     * @param data 发送的数据,必须重写toString()方法,否则不能正确记录日志信息
     * @param returnType 返回类型,必须重写toString()方法,否则不能正确记录日志信息
     * @return 指定的返回类型
     */
    public <T, E> T doPostByJson(String url, E data, HttpHeaders headers, Class<T> returnType) {
        return doPost(url, data, MediaType.APPLICATION_JSON_UTF8,headers, returnType);
    }

    /**
     * 发送POST请求
     * @param url 请求url
     * @param data 发送的数据,必须重写toString()方法,否则不能正确记录日志信息
     * @param returnType 返回类型,必须重写toString()方法,否则不能正确记录日志信息
     * @return 指定的返回类型
     */
    public <T> T doPostByFormData(String url, MultiValueMap<String, Object> data, HttpHeaders headers, Class<T> returnType) {
        return doPost(url, data, MediaType.APPLICATION_FORM_URLENCODED,headers, returnType);
    }

    /**
     * 发送GET请求
     * @param url 请求url
     * @param clazz 返回类型,必须重写toString()方法,否则不能正确记录日志信息
     * @return 指定的返回类型
     */
    public <T> T doGet(String url, Class<T> clazz) {
//        log.info("GET_REQUEST: {}, {}", url, clazz.getName());

        T result = restTemplate.getForObject(url, clazz);
//        log.info("GET_RESPONSE: {}", result);

        return result;
    }
    public <T> T doGet(String url, Class<T> clazz, HttpHeaders headers) {
//        log.info("GET_REQUEST: {}, {}", url, clazz.getName());
        HttpEntity entity = new HttpEntity(headers);
        T result = restTemplate.getForObject(url, clazz,entity);
//        log.info("GET_RESPONSE: {}", result);

        return result;
    }
    /**
     * 发送POST请求
     * @param url 请求url
     * @param data 发送的数据,必须重写toString()方法,否则不能正确记录日志信息
     * @param requestType 请求头类型
     * @param returnType 返回类型,必须重写toString()方法,否则不能正确记录日志信息
     * @return 指定的返回类型
     */
    public <T, E> T doPost(String url, E data, MediaType requestType, HttpHeaders headers, Class<T> returnType) {
//        log.info("POST_REQUEST: {}, {}, {}, {}", url, data, requestType, returnType.getName());
        headers.setContentType(requestType);
        HttpEntity<E> entity = new HttpEntity<>(data, headers);

        T result = restTemplate.postForObject(url, entity, returnType);

//        log.info("POST_RESPONSE: {}", result);

        return result;
    }
    public static void main(String[] args) throws Exception {
        RestTemplateUtil restTemplateUtil = new RestTemplateUtil();
//        String url = "http://182.245.127.20:8089/sbr/questionnaireinvestigation/getEncodeReportById";
//        url = url + "?uuid=7d005905d04144209d3b3ce9b3483575";

        long startTime = System.currentTimeMillis();



//        String body="{\"sid\":\"naMOoolin0uhFWSJN09%2BRjuo2brEQ0JAOoKQpnnT3f9cRC8fPRpjvDEpQXg%2FXUK7\"}";
//        String decResult = doPost(url, "", headersMap,body);
//        long startTime2 = System.currentTimeMillis();
//        System.out.println("返回疫苗预约结果总共耗时："+(startTime2-startTime) + "ms");
//        System.out.println(decResult);

        JSONObject jsondata=new JSONObject();
        jsondata.put("sid","naMOoolin0uhFWSJN09%2BRjuo2brEQ0JAOoKQpnnT3f9cRC8fPRpjvDEpQXg%2FXUK7");
//        doPost(url,headersMap,jsondata);
//        RespResult str = restRespResult(jsondata);
        long startTime2 = System.currentTimeMillis();
        System.out.println("返回疫苗预约结果总共耗时："+(startTime2-startTime) + "ms");

    }
}
