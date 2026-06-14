package servlet;

import dao.GameRecordDao;
import dto.GameRecordDto;
import dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/record/list")
public class RecordListServlet extends HttpServlet {

    private GameRecordDao gameRecordDao = new GameRecordDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 세션 체크
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("loginUser") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // 세션에서 로그인 유저 꺼내기
        UserDto loginUser = (UserDto) session.getAttribute("loginUser");

        // 해당 유저의 전적 목록 조회
        List<GameRecordDto> records = gameRecordDao.findByUserId(loginUser.getId());

        // JSP에 전달
        req.setAttribute("records", records);
        req.setAttribute("loginUser", loginUser);
        req.getRequestDispatcher("/record_list.jsp").forward(req, resp);
    }
}