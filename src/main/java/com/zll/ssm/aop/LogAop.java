package com.zll.ssm.aop;

import com.zll.ssm.annotation.LogAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect
@Component
public class LogAop {
    //定义一个切入点
    @Pointcut("execution(* com.zll.ssm.controller.*Controller.*(..))")
    private void anyMethod(){
        System.out.println("切面");
    }

    @Before("anyMethod() && args(name)")
    public void doAccessCheck(String name){
        System.out.println(name);
        System.out.println("前置通知");
    }

    @AfterReturning("anyMethod()")
    public void doAfter(){
        System.out.println("后置通知");
    }

    @After("anyMethod()")
    public void after(JoinPoint point){
        System.out.println("最终通知");
    }

    @AfterThrowing("anyMethod()")
    public void doAfterThrow(){
        System.out.println("例外通知");
    }


    //@Around("anyMethod()")
    @Around("execution(* com.zll.ssm.controller.*Controller.*(..))")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        //获取接口的方法
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature)signature;
        Method targetMethod = methodSignature.getMethod();

        //接口的化获取实现类的方法
        if (targetMethod.getDeclaringClass().isInterface()) {
            try {
                targetMethod= pjp.getTarget().getClass().getDeclaredMethod(pjp.getSignature().getName(), targetMethod.getParameterTypes());
            } catch (final SecurityException exception) {
                //...
            } catch (final NoSuchMethodException exception) {
                //...
            }
        }

        //获取实现类的方法
        Signature sig = pjp.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Object target = pjp.getTarget();
        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());

        System.out.println("获取实现类的方法"+currentMethod);


        System.out.println("classname:" + targetMethod.getDeclaringClass().getName());
        System.out.println("superclass:" + targetMethod.getDeclaringClass().getSuperclass().getName());
        System.out.println("isinterface:" + targetMethod.getDeclaringClass().isInterface());
        System.out.println("target:" + pjp.getTarget().getClass().getName());
        System.out.println("proxy:" + pjp.getThis().getClass().getName());
        System.out.println("method:" + targetMethod.getName());

        String monthRemark = getMthodRemark(pjp);
        String monthName = pjp.getSignature().getName();
        String packages = pjp.getThis().getClass().getName();
        if (packages.indexOf("$$EnhancerByCGLIB$$") > -1) { // 如果是CGLIB动态生成的类
            try {
                packages = packages.substring(0, packages.indexOf("$$"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        String operatingcontent = "";
        Object[] method_param = null;

       /* Object object;
        try {
            method_param = pjp.getArgs();	//获取方法参数
            // String param=(String) point.proceed(point.getArgs());
            object = pjp.proceed();
        } catch (Exception e) {
            // 异常处理记录日志..log.error(e);
            throw e;
        }
*/

       //获取参数
        Class[] parameterTypes = new Class[pjp.getArgs().length];
        Object[] args = pjp.getArgs();
        //判断参数中是否有空
        boolean falg =true;
        for(int i=0; i<args.length; i++) {
            if(args[i] != null) {
                parameterTypes[i] = args[i].getClass();
            }else {
                falg = false;
                parameterTypes[i] = null;
            }
        }

        //获取代理方法对象
        if(falg) {
            String methodName = pjp.getSignature().getName();
            Method method = pjp.getSignature().getDeclaringType().getMethod(methodName, parameterTypes);
            if(method.isAnnotationPresent(LogAnnotation.class)){
                System.out.println("存在1");
            }
        }

        //获取实际方法对象,可以获取方法注解等
        Method realMethod = pjp.getTarget().getClass().getDeclaredMethod(signature.getName(), targetMethod.getParameterTypes());

        if(realMethod.isAnnotationPresent(LogAnnotation.class)){
            realMethod.getAnnotation(LogAnnotation.class).operateDescribe();
            System.out.println("存在2");
        }

        System.out.println("进入环绕通知");
        Object object = pjp.proceed();//执行该方法
        System.out.println("退出方法");
        return object;
    }

    // 获取方法的中文备注____用于记录用户的操作日志描述
    public static String getMthodRemark(ProceedingJoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        System. out.println("====调用" +methodName+"方法-开始！");
        Object[] arguments = joinPoint.getArgs();   //获得参数列表
        System.out.println("打印出方法调用时传入的参数，可以在这里通过添加参数的类型，进行一些简易逻辑处理和判断");
        if(arguments.length<=0){
            System.out.println("=== "+methodName+" 方法没有参数");
        }else{
            for(int i=0;i<arguments.length;i++){
                System.out.println("==== 参数   "+(i+1)+" : "+arguments[i]);
            }
        }

        Class targetClass = Class.forName(targetName);
        Method[] method = targetClass.getMethods();
        String methode = "";
        for (Method m : method) {
            if (m.getName().equals(methodName)) {
                Class[] tmpCs = m.getParameterTypes();
                if (tmpCs.length == arguments.length) {
                    LogAnnotation methodCache = m.getAnnotation(LogAnnotation.class);
                 //   methode = methodCache.operateModelNm();
                    break;
                }
            }
        }
        return methode;
    }
}