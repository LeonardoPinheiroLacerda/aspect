package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.demo.dummy.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before: " + joinPoint.getSignature());
    }

    /*
        execution               = Quando executar...
        *                       = qualquer método que retorne qualquer coisa
        com.example.demo.dummy  = que esteja dentro do pacote
        *.*                     = qualquer classe, qualquer método
        (..)                    = qualquer conjunto de argumentos
    */
    @Around("execution(* com.example.demo.dummy.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around Before: " + joinPoint.getSignature());

        Object proceed = joinPoint.proceed();

        System.out.println("Around After: " + joinPoint.getSignature());

        return proceed;
    }

    /*execution(@com.example.demo.hello.HelloAnnotation * *(..)):
        Captura qualquer método (* *(..)),
        independentemente do tipo de retorno (*),
        que esteja anotado com @HelloAnnotation.
     */
    @Around("execution(@com.example.demo.hello.HelloAnnotation * *(..))")
    public Object logAroundAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around hello Before Annotation: " + joinPoint.getSignature());

        Object proceed = joinPoint.proceed();

        System.out.println("Around hello After Annotation: " + joinPoint.getSignature());

        return proceed;
    }

}
