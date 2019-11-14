package io.hpb.aspect;

import io.hpb.util.UUIDGeneratorUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Aspect
@Component
public class ControllerAspect {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);


    /**
     * 定义拦截规则：拦截com.hpb.bc.controller包下面的所有类中，有@RequestMapping注解的方法。
     */
    @Pointcut("execution(* io.hpb.contract.controller..*(..)) and @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void controllerMethodPointcut() {
    }

    /**
     * 拦截器具体实现
     *
     * @param pjp
     * @return JsonResult（被拦截方法的执行结果，或需要登录的错误提示。）
     * @throws Throwable
     */
    @SuppressWarnings({"unchecked", "rawtypes", "unused"})
    @Around("controllerMethodPointcut()") //指定拦截器规则
    public Object Interceptor(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod(); //获取被拦截的方法
        String methodName = method.getName(); //获取被拦截的方法名

        Set<Object> allParams = new LinkedHashSet<>(); //保存所有请求参数，用于输出到日志中

        logger.info("请求开始，方法：{}", methodName);
        Object result = null;
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            //logger.debug("arg: {}", arg);
            if (arg instanceof Map<?, ?>) {
                //提取方法中的MAP参数，用于记录进日志中
                Map<String, Object> map = (Map<String, Object>) arg;

                allParams.add(map);
            } else if (arg instanceof HttpServletRequest) {
                HttpServletRequest request = (HttpServletRequest) arg;
                if (isLoginRequired(method)) {
                    if (!isLogin(request)) {
//                        result = new JsonResult(ResultCode.NOT_LOGIN, "该操作需要登录！去登录吗？\n\n（不知道登录账号？请联系老许。）", null);
                    }
                }

                //获取query string 或 posted form data参数
                Map<String, String[]> paramMap = request.getParameterMap();
                if (paramMap != null && paramMap.size() > 0) {
                    allParams.add(paramMap);
                }
            } else if (arg instanceof HttpServletResponse) {
                //do nothing...
            } else {
                //allParams.add(arg);
            }
        }
        //添加处理进程号
        if (args[0] instanceof List<?>) {
            List req = (List) args[0];
            req.add(0, UUIDGeneratorUtil.generate(pjp));
        }

////      try {
//        if(result == null){
//            // 一切正常的情况下，继续执行被拦截的方法
//            result = pjp.proceed();
//        }
////        } catch (Throwable e) {
////            logger.info("exception: ", e);
//////            result = new JsonResult(ResultCode.EXCEPTION, "发生异常："+e.getMessage());
////        }

//        if(result instanceof Result){
//        	Result<?> target = (Result<?>)result;
//        	result = Arrays.asList(target.getCode(),target.getMsg(),target.getData());
//        }

//        return result;
        return pjp.proceed();
    }

    /**
     * 判断一个方法是否需要登录
     *
     * @param method
     * @return
     */
    private boolean isLoginRequired(Method method) {

        boolean result = true;

        return result;
    }

    //判断是否已经登录
    private boolean isLogin(HttpServletRequest request) {
        return true;
    }
}