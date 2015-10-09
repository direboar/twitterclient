package com.twitterclient.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Aspect
@Component
public class DebuggingInterceptor {
	@Around("execution(* com.twitterclient..*.*(..))")
	public Object intercept(ProceedingJoinPoint pjp) throws Throwable {
		LoggerFactory.getLogger("app").debug(pjp.getSignature().toLongString());
		LoggerFactory.getLogger("app").debug(StringUtils.arrayToCommaDelimitedString(pjp.getArgs()));
		Object o = pjp.proceed();
		return o;
	}
}
