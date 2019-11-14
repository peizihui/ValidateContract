package io.hpb.aspect;

import io.hpb.configure.DynmicDataSourceContextHolder;
import io.hpb.configure.TargetDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(-1)
@Component
public class DynamicDataSourceAspect {

    /**
     * 自定义注解拦截
     *
     * @param point
     * @param targetDataSource
     * @throws Throwable
     */
    @Before("@annotation(targetDataSource)")
    public void setDataSourceType(JoinPoint point, TargetDataSource targetDataSource) throws Throwable {
        DynmicDataSourceContextHolder.setDataSourceKey(targetDataSource.value());
    }
}
