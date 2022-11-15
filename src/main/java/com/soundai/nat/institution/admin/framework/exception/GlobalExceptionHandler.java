package com.soundai.nat.institution.admin.framework.exception;

import com.soundai.nat.institution.admin.framework.exception.user.CaptchaException;
import com.soundai.nat.institution.admin.framework.exception.user.CaptchaExpireException;
import com.soundai.nat.institution.admin.framework.exception.user.UserPasswordNotMatchException;
import com.soundai.nat.institution.admin.framework.web.domain.RespResult;
import com.soundai.nat.institution.admin.framework.web.domain.RespStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 全局异常处理器
 *
 * @author soundai
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 业务异常
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> businessException(CustomException e) {
        log.error("自定义业务错误" + e.getMessage(), e);
        return RespResult.fail(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<?> handlerNoFoundException(Exception e) {
        log.error("路径不存在，请检查路径是否正确" + e.getMessage(), e);
        return RespResult.fail(RespStatus.RS_PATH_NOT_EXIST, "路径不存在，请检查路径是否正确");
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handleAuthorizationException(AccessDeniedException e) {
        log.error("没有权限，请联系管理员授权" + e.getMessage());
        return RespResult.fail(RespStatus.RS_FORBIDDEN, "没有权限，请联系管理员授权");
    }

    @ExceptionHandler(AccountExpiredException.class)
    public ResponseEntity<?> handleAccountExpiredException(AccountExpiredException e) {
        log.error("账号错误" + e.getMessage(), e);
        return RespResult.fail(RespStatus.RS_ACCOUNT_FAIL, "账号错误");
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> handleUsernameNotFoundException(UsernameNotFoundException e) {
        log.error("用户不存在" + e.getMessage(), e);
        return RespResult.fail(RespStatus.RS_FORBIDDEN_NOFOUND, "用户不存在");
    }

    /**
     * 登录用户密码异常
     */
    @ExceptionHandler(UserPasswordNotMatchException.class)
    public ResponseEntity<?> userPasswordException(UserPasswordNotMatchException e) {
        log.error("登录用户密码异常" + e.getMessage(), e);
        return RespResult.fail(RespStatus.RS_ACCOUNT_FAIL, e.getMessage());
    }

    /**
     * 验证码不正确异常
     */
    @ExceptionHandler(CaptchaException.class)
    public ResponseEntity<?> captchaException(CaptchaException e) {
        log.error("验证码不正确异常" + e.getMessage(), e);
        return RespResult.fail(RespStatus.RS_CAPTCHA_FAIL, e.getMessage());
    }

    /**
     * 验证码失效异常
     */
    @ExceptionHandler(CaptchaExpireException.class)
    public ResponseEntity<?> captchaExpireException(CaptchaExpireException e) {
        log.error("验证码失效异常" + e.getMessage(), e);
        return RespResult.fail(RespStatus.RS_CAPTCHA_FAIL, e.getMessage());
    }

    /**
     * 自定义验证异常
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<?> validatedBindException(BindException e) {
        log.error("验证绑定异常" + e.getMessage(), e);
        String message = e.getAllErrors().get(0).getDefaultMessage();
        return RespResult.fail(RespStatus.RS_VALIDATED_BIND, message);
    }

    /**
     * 自定义验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validExceptionHandler(MethodArgumentNotValidException e) {
        log.error("验证异常" + e.getMessage(), e);
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        return RespResult.fail(RespStatus.RS_VALIDATED_BIND, message);
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResponseEntity<?> handleNpeException(NullPointerException exception) {
        log.error("NPE错误: " + exception.getMessage(), exception);
        return RespResult.fail(RespStatus.RS_INTERNAL_ERROR, "系统错误");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        log.error("全局异常" + e.getMessage(), e);
        return RespResult.fail(RespStatus.RS_INTERNAL_ERROR, "系统错误");
    }

}
