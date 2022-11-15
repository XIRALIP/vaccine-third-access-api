package com.soundai.nat.institution.admin.framework.exception;

import com.soundai.nat.institution.admin.framework.web.domain.RespStatus;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * 自定义异常
 *
 * @author azero
 */
@Data
public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private Integer code;

    private String message;

    public CustomException(RespStatus status) {
        this.code = status.getCode();
        this.message = status.getMsg();
    }

    public CustomException(Integer code, List<String> messageList) {
        this.code = code;
        this.message = String.join("-", messageList);
    }

    public CustomException(String message)
    {
        this.message = message;
    }

    public CustomException(Integer code,String message) {
        this.code = code;
        this.message = message;
    }

}
