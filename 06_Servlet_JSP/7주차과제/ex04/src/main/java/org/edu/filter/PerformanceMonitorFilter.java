package org.edu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebFilter("/*")  // 모든 요청에 적용
public class PerformanceMonitorFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // 요청 접수 시간
        long startTime = System.currentTimeMillis();
        String now = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // 다음 필터 or 서블릿으로 넘기기
        chain.doFilter(request, response);

        // 처리 완료 후 수행 시간 계산
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        // 로그 출력: [요청 접수 시간] <요청 url> - <처리 수행 시간> 소요.
        System.out.println("[" + now + "] " +
                ((javax.servlet.http.HttpServletRequest) request).getRequestURI() +
                " - " + duration + "ms 소요.");
    }
}