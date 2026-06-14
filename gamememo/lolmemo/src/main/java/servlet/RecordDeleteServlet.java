package servlet;

import dao.GameRecordDao;
import dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/record/delete")
public class RecordDeleteServlet extends HttpServlet {

    private GameRecordDao gameRecordDao = new GameRecordDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 세션 체크
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("loginUser") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        UserDto loginUser = (UserDto) session.getAttribute("loginUser");
        int recordId = Integer.parseInt(req.getParameter("recordId"));

        gameRecordDao.delete(recordId, loginUser.getId());

        resp.sendRedirect(req.getContextPath() + "/record/list");
    }
}