package servlet;

import dao.UserDao;
import dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserDao userDao = new UserDao();

    // 회원가입 폼 보여주기
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    // 회원가입 처리
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 아이디 중복 체크
        if (userDao.existsUsername(username)) {
            req.setAttribute("error", "이미 사용중인 아이디입니다.");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }

        // DB에 저장
        UserDto user = new UserDto();
        user.setUsername(username);
        user.setPassword(password);

        int result = userDao.insert(user);

        if (result > 0) {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        } else {
            req.setAttribute("error", "회원가입 실패. 다시 시도해주세요.");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }
}