package org.scoula.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {

    // 1. 기존의 기본 Before Advice (구분선 출력)
    @Before("execution(* org.scoula.sample.service.SampleService.*(..))")
    public void log() {
        System.out.println("==================================");
    }

    // 2. 새로 추가된 매개변수 체크 Before Advice (PPT 마지막 페이지 조건)
    @Before("execution(* org.scoula.sample.service.SampleService.doAdd(..))")
    public void logArgs(JoinPoint jp) {
        System.out.println("[매개변수 체크]");
        Object[] args = jp.getArgs();
        if (args != null && args.length >= 2) {
            System.out.println("str1: " + args[0]);
            System.out.println("str2: " + args[1]);
        }
    }
}