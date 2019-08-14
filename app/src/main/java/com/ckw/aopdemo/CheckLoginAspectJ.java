package com.ckw.aopdemo;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by ckw
 * on 2019/8/14.
 */
@Aspect
public class CheckLoginAspectJ {

    private static final String TAG = "CheckLogin";

    /**
     * 找到处理的切点
     * * *(..)  可以处理CheckLogin这个类所有的方法
     */
    @Pointcut("execution(@com.ckw.aopdemo.CheckLogin  * *(..))")
    public void executionCheckLogin() {
    }

    /**
     * 处理切面
     *
     * @param joinPoint
     * @return
     */
    @Around("executionCheckLogin()")
    public Object checkLogin(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.i(TAG, "checkLogin: ");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        CheckLogin checkLogin = signature.getMethod().getAnnotation(CheckLogin.class);
        String value = checkLogin.value();
        Log.d("----", "checkLogin: 来自"+value);
        if (checkLogin != null) {
            Context context = (Context) joinPoint.getThis();
            if (false) {
                Log.d("----", "checkLogin: 已经登录");
                return joinPoint.proceed();
            } else {
                Log.d("----", "checkLogin: 没有登录");
                Toast.makeText(context, "请登录", Toast.LENGTH_SHORT).show();
                return null;
            }
        }
        return joinPoint.proceed();
    }
}
