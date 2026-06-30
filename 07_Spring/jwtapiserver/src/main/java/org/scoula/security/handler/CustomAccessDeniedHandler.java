package org.scoula.security.handler;

import lombok.extern.slf4j.Slf4j;
import org.scoula.security.util.JsonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    // AccessDeniedHandler : 인증은 성공 했지만 권한이 부족할 때 실행되는 인터페이스

    @Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException accessDeniedException
    ) throws IOException, ServletException {

        log.error("========== 인가 에러 ============");
        JsonResponse.sendError(
                response,
                HttpStatus.FORBIDDEN,
                "권한이 부족합니다."
        );
    }
}