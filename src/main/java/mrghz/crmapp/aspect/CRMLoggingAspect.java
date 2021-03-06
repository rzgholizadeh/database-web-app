package mrghz.crmapp.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// setup pointcut declarations
	@Pointcut("execution(* com.mrghz.crmapp.controller.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut("execution(* com.mrghz.crmapp.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.mrghz.crmapp.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage() ")
	private void forAppFlow() {
	}

	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {

		// display method being called
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @Before: calling method: " + theMethod);

		// display the arguments to the method

		// get the arguments
		Object[] args = theJoinPoint.getArgs();

		// loop through and display arguments
		for (Object tempArg : args) {
			myLogger.info("=====>> argument: " + tempArg);
		}
	}

	// add @After advice
	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {

		// display method being returned from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @AfterReturning: from method: " + theMethod);

		// display data returned
		myLogger.info("=====>> result: " + theResult);
	}
}
