package miu.edu.cs545assignment.aspect;

import miu.edu.cs545assignment.domain.Logger;
import miu.edu.cs545assignment.service.LoggerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserControllerAspect {

    private final LoggerService loggerService;

    @Autowired
    public UserControllerAspect(LoggerService loggerService) {
        this.loggerService = loggerService;
    }
    @AfterReturning(value =
            "execution(* miu.edu.cs545assignment..*(..)) " +
            "&& !execution(* miu.edu.cs545assignment.service.LoggerService..*(..))" +
            "&& !execution(* miu.edu.cs545assignment.aspect..*(..))" +
            "&& !execution(* miu.edu.cs545assignment.repository.LoggerRepository..*(..))")
    public void logToDatabase(JoinPoint joinPoint) {
        try {
            Logger logger = new Logger();
            logger.setTransactionDate(java.time.LocalDate.now());
            logger.setTransactionTime(java.time.LocalTime.now());
            logger.setPrinciple(1);
            logger.setOperation(joinPoint.getSignature().toLongString());
            loggerService.save(logger);
        } catch (Exception e) {
            System.err.println("Error logging to database: " + e.getMessage());
        }
    }

    @Around("@annotation(miu.edu.cs545assignment.aspect.ExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("Execution time of " + joinPoint.getSignature() + " is " + (endTime - startTime) + " ms");
        return proceed;
    }

    @Around(value = "execution(* miu.edu.cs545assignment.controller.UserController.*(..))")
    public void logAfter(ProceedingJoinPoint proJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        System.out.println(
                "The method aroundAdvice() before invocation of the method "
                        + proJoinPoint.getSignature().getName()
                        + " method");
        try {
            proJoinPoint.proceed();
        }
        finally {
            long endTime = System.currentTimeMillis();
            System.out.println(
                    "The method aroundAdvice() took "
                            + (endTime - startTime)
                            + " milliseconds for the method "
                            + proJoinPoint.getSignature().getName()
                            + " method");
        }
    }
}
