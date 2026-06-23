package org.scoula.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect        // AOP Aspect임을 선언
@Slf4j          // Lombok 로깅 어노테이션
@Component      // Spring Bean으로 등록
public class LogAdvice {
    /* @Around 실행 흐름
    1. @Around Advice 시작
    2. proceed() 호출 전 작업 (Before와 같은 역할)
    3. proceed() → Target 메서드 실행
    4. proceed() 호출 후 작업 (After와 같은 역할)
    5. 최종 결과 반환
    */
    @Around("execution(* org.scoula.sample.service.SampleService*.*(..))")
    public Object logTime(ProceedingJoinPoint pjp) {

        // ProceedingJoinPoint : @Aroung 에서만 사용 가능한 JoinPoint 객체
        // JoinPoint : AOP의 부가 기능이 적용된 대상의 객체, 메서드. 파라미터 정보를 얻을수 있게해주는개 객체

        long start = System.currentTimeMillis();  // 시작 시간 기록

        // Target 객체 정보 로깅
        log.info("Target: " + pjp.getTarget());
        // 전달된 파라미터 로깅
        log.info("Param: " + Arrays.toString(pjp.getArgs()));

        Object result = null;
        try {
            result = pjp.proceed();  // 실제 메서드 실행
        } catch(Throwable e) {
            e.printStackTrace();     // 예외 처리
        }

        long end = System.currentTimeMillis();    // 종료 시간 기록
        log.info("TIME: " + (end - start) + "ms");       // 실행 시간 로깅

        return result;  // 결과 반환
    }
}
