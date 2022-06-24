package com.javatechie.spring.aop.api.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAdvice {

//	Logger log = LoggerFactory.getLogger(LoggingAdvice.class);
//
//	@Pointcut(value="execution(* com.javatechie.spring.aop.api.*.*.*(..) )")
//	public void myPointcut() {
//
//	}
//
//	@Around("myPointcut()")
//	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
//		ObjectMapper mapper = new ObjectMapper();
//		String methodName = pjp.getSignature().getName();
//		String className = pjp.getTarget().getClass().toString();
//		Object[] array = pjp.getArgs();
//		log.info("method invoked " + className + " : " + methodName + "()" + "arguments : "
//				+ mapper.writeValueAsString(array));
//		Object object = pjp.proceed();
//		log.info(className + " : " + methodName + "()" + "Response : "
//				+ mapper.writeValueAsString(object));
//		return object;
//	}


		private static org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);
		@Around("execution(* *(..)) && @annotation(com.javatechie.spring.aop.api.advice.MethodStats)")
		public Object log(ProceedingJoinPoint point) throws Throwable
		{
			long start = System.currentTimeMillis();
			Object result = point.proceed();
			logger.info("className={}, methodName={}, timeMs={},threadId={}",new Object[]{
					MethodSignature.class.cast(point.getSignature()).getDeclaringTypeName(),
					MethodSignature.class.cast(point.getSignature()).getMethod().getName(),
					System.currentTimeMillis() - start,
					Thread.currentThread().getId()}
			);
			return result;
		}
	}

