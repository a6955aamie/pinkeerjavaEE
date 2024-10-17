package org.example;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CustomAspects {

    @Pointcut("execution(public void org.example.UserServiceImpl.*(..))")
    public void pointcut(){};
//    加入了切点之后，简便很多，如果没有切点，原来下面pointcut()都要写成execution(public void org.example.UserServiceImpl.*(..))



    @Before("pointcut()")
    public void BeforeMetheod(){
        System.out.println("前置通知Before Method被执行");
    }

    @After("pointcut()")
    public void adviseAfter(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "后置通知：关闭文件……");
    }
    @Around("pointcut()")
    public Object adviseAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println(proceedingJoinPoint.getSignature().getName()
                + "环绕通知：执行前日志记录……");
        Object object = proceedingJoinPoint.proceed();
        System.out.println(proceedingJoinPoint.getSignature().getName()
                + "环绕通知：执行后日志记录……");
        return object;
    }
    @AfterThrowing(value = "pointcut()", throwing = "e")
    public void adviseThrow(JoinPoint joinPoint, Throwable e) {
        System.out.println(joinPoint.getSignature().getName() + "异常通知：" + e.getMessage());
    }
    @AfterReturning("pointcut()")
    public void adviseReturn(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "返回通知：释放资源……");
    }

}
