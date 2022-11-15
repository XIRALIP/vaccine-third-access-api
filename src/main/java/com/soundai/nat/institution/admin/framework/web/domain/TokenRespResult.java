package com.soundai.nat.institution.admin.framework.web.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class TokenRespResult implements Serializable {

    private static final long serialVersionUID = -637982651930525547L;

    private Integer code;

    private String message;

    private Object data;

    public TokenRespResult(RespStatus status) {
        this.code = status.getCode();
        this.message = status.getMsg();
    }

    public static ResponseEntity ok() {
        return ok(null);
    }

    public static ResponseEntity ok(Object data) {
        TokenRespResult result = new TokenRespResult(RespStatus.RS_OK);
        result.setData(data);
        return new ResponseEntity<>(result, getHttpCode());
    }

    public static ResponseEntity fail() {
        return fail(RespStatus.RS_INTERNAL_ERROR);
    }

    public static ResponseEntity fail(RespStatus status) {
        TokenRespResult result = new TokenRespResult(status);
        return new ResponseEntity<>(result, getHttpCode());
    }

    public static ResponseEntity fail(RespStatus status, String msg) {
        TokenRespResult result = new TokenRespResult(status);
        result.setMessage(msg);
        return new ResponseEntity<>(result, getHttpCode());
    }

    public static ResponseEntity fail(RespStatus status, List<String> msg) {
        TokenRespResult result = new TokenRespResult(status);
        result.setData(msg);
        return new ResponseEntity<>(result, getHttpCode());
    }

    public static ResponseEntity fail(int errorCode, String msg) {
        TokenRespResult result = new TokenRespResult();
        result.setCode(errorCode);
        result.setMessage(msg);
        return new ResponseEntity<>(result, getHttpCode());
    }

    private static HttpStatus getHttpCode() {
        return HttpStatus.valueOf(200);
    }

}
