package org.edu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/deco/*")  // /deco로 시작하는 요청에만 적용
public class DecoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // 요청 처리 전
        String url = ((javax.servlet.http.HttpServletRequest) request).getRequestURI();
        System.out.println(url + " =======>");

        // 다음 필터 or 서블릿으로 넘기기
        chain.doFilter(request, response);

        // 요청 처리 후
        System.out.println("<========");
    }
}