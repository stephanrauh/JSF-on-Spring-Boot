package de.beyondjava.examples.scopes.spring;

import java.lang.reflect.Field;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Around("execution(public java.lang.String *.getCounter(..))")
	public Object logBefore(ProceedingJoinPoint joinPoint) throws Throwable {
		String msg = "(null) -> ";
		Object target = joinPoint.getTarget();
		try {
			Field counterField = target.getClass().getDeclaredField("counter");
			int counter = (int) counterField.get(target);
			msg = String.valueOf(counter) + " -> ";
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s = (String)joinPoint.proceed();
		return msg + s;
	}

}