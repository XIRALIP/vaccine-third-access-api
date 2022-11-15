package com.soundai.nat.institution.admin.framework.web.domain;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class ThirdRespResult implements Serializable {

    private static final long serialVersionUID = -637982651930525547L;

    private Integer code;

    private String msg;

    public ThirdRespResult(RespStatus status) {
        this.code = status.getCode();
        this.msg = status.getMsg();
    }

    public static ResponseEntity ok() {
        return ok(null);
    }

    public static ResponseEntity ok(Object data) {
        ThirdRespResult result = new ThirdRespResult(RespStatus.RS_OK);
        return new ResponseEntity<>(result, getHttpCode());
    }

    public static ResponseEntity fail() {
        return fail(RespStatus.RS_INTERNAL_ERROR);
    }

    public static ResponseEntity fail(RespStatus status) {
        ThirdRespResult result = new ThirdRespResult(status);
        return new ResponseEntity<>(result, getHttpCode());
    }

    public static ResponseEntity fail(RespStatus status, String msg) {
        ThirdRespResult result = new ThirdRespResult(status);
        result.setMsg(msg);
        return new ResponseEntity<>(result, getHttpCode());
    }

    public static ResponseEntity fail(RespStatus status, List<String> msg) {
        ThirdRespResult result = new ThirdRespResult(status);
        return new ResponseEntity<>(result, getHttpCode());
    }

    public static ResponseEntity fail(int errorCode, String msg) {
        ThirdRespResult result = new ThirdRespResult();
        result.setCode(errorCode);
        result.setMsg(msg);
        return new ResponseEntity<>(result, getHttpCode());
    }

    private static HttpStatus getHttpCode() {
        return HttpStatus.valueOf(200);
    }

}
