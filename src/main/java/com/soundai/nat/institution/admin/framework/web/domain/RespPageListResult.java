package com.soundai.nat.institution.admin.framework.web.domain;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.List;

@Data
public class RespPageListResult implements Serializable {

    private static final long serialVersionUID = -637982651930525547L;

    private Integer code;

    private String message;

    private List<?> data;

    private long totalCount;

    public RespPageListResult(RespStatus status) {
        this.code = status.getCode();
        this.message = status.getMsg();
    }

    public static ResponseEntity ok() {
        return ok(null,0);
    }

    public static ResponseEntity ok(List<?> data, long totalCount) {
        RespPageListResult result = new RespPageListResult(RespStatus.RS_OK);
        result.setData(data);
        result.setTotalCount(totalCount);
        return new ResponseEntity<>(result, getHttpCode(result.getCode()));
    }

    public static ResponseEntity fail() {
        return fail(RespStatus.RS_INTERNAL_ERROR);
    }

    public static ResponseEntity fail(RespStatus status) {
        RespPageListResult result = new RespPageListResult(status);
        return new ResponseEntity<>(result, getHttpCode(result.getCode()));
    }

    public static ResponseEntity fail(RespStatus status, String msg) {
        RespPageListResult result = new RespPageListResult(status);
        result.setMessage(msg);
        return new ResponseEntity<>(result, getHttpCode(result.getCode()));
    }

    private static HttpStatus getHttpCode(int code) {
        return HttpStatus.valueOf(200);
    }

}
