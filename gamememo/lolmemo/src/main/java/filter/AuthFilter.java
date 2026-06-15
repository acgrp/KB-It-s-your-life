package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {

    // 로그인 없이 접근 가능한 경로
    private static final String[] WHITE_LIST = {
            "/login", "/register", "/index.jsp", "/login.jsp", "/register.jsp"
    };

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req   = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();
        String path = uri.substring(contextPath.length());

        // 화이트리스트 경로면 그냥 통과
        if (isWhiteList(path)) {
            chain.doFilter(request, response);
            return;
        }

        // 세션 체크
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("loginUser") == null) {
            resp.sendRedirect(contextPath + "/login");
            return;
        }

        // 로그인 됐으면 통과
        chain.doFilter(request, response);
    }

    private boolean isWhiteList(String path) {
        for (String white : WHITE_LIST) {
            if (path.equals(white)) {
                return true;
            }
        }
        return false;
    }

    @Override public void init(FilterConfig filterConfig) {}
    @Override public void destroy() {}
}