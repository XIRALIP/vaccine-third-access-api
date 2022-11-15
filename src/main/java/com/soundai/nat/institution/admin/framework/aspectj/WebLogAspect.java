package com.soundai.nat.institution.admin.framework.aspectj;
import com.soundai.nat.institution.admin.framework.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.soundai.nat.institution.admin.framework.utils.thread.Constants.TRACE_ID;

@Component
@Slf4j
@Aspect
public class WebLogAspect {
    private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

    private static final String START_TIME = "startTime";

    private static final String REQUEST_PARAMS = "requestParams";

    private static final String REQUEST_URL = "requestUrl";
    //    private static final String TRACE_ID = "traceId";
    @Pointcut("execution(* com.soundai.nat.institution.admin.module.*.controller..*.*(..))")
    public void moduleWebLog() {}
    @Before("moduleWebLog()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        log.info("开始调用");
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL()==null?"":request.getRequestURL().toString();
        long startTime = System.currentTimeMillis();
        Map<String, Object> threadInfo = new HashMap<>();
        threadInfo.put(START_TIME, startTime);
        // 请求参数。
        threadInfo.put(REQUEST_PARAMS, Arrays.toString(joinPoint.getArgs()));
        threadInfo.put(REQUEST_URL, url);
        threadLocal.set(threadInfo);
        log.info("{}接口开始调用，请求参数={}",
                url,Arrays.toString(joinPoint.getArgs()));
    }
    @AfterReturning(pointcut = "moduleWebLog()", returning = "res")
    public void doAfterReturning(Object res){
        Map<String, Object> threadInfo = threadLocal.get();
        long takeTime = System.currentTimeMillis() - (long) threadInfo.getOrDefault(START_TIME, System.currentTimeMillis());
        if(StringUtils.isNotNull(res)
                && StringUtils.isNotBlank(res.toString())
                && res.toString().length() > 7 ){
            res= res.toString().substring(1,7);
        }
        log.info("{}接口结束调用:耗时={}ms  result={} ",
                threadInfo.getOrDefault(REQUEST_URL,"").toString(),
                takeTime,res);
        log.info("结束调用");
        threadLocal.remove();
        MDC.remove(TRACE_ID);

    }
    @AfterThrowing(pointcut = "moduleWebLog()", throwing = "throwable")
    public void doAfterThrowing(Throwable throwable) { Map<String, Object> threadInfo = threadLocal.get();log.info("{}接口调用异常，异常信息={}",
            threadInfo.getOrDefault(REQUEST_URL,""),
            throwable);
        log.info("结束调用");
        threadLocal.remove();
        MDC.remove(TRACE_ID);
    }
    @Around("moduleWebLog()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object ob = pjp.proceed();
        log.info("执行耗时={}ms", (System.currentTimeMillis() - startTime));
        return ob;
    }

}
