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

@WebServlet("/record/save")
public class RecordSaveServlet extends HttpServlet {

    private GameRecordDao gameRecordDao = new GameRecordDao();

    // 전적 입력 폼 보여주기
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("loginUser") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        req.getRequestDispatcher("/record_form.jsp").forward(req, resp);
    }

    // 전적 저장 처리
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        // 세션 체크
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("loginUser") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // 세션에서 로그인 유저 꺼내기
        UserDto loginUser = (UserDto) session.getAttribute("loginUser");

        // 폼 데이터 꺼내기
        String champion = req.getParameter("champion");
        String result   = req.getParameter("result");
        int kills       = Integer.parseInt(req.getParameter("kills"));
        int deaths      = Integer.parseInt(req.getParameter("deaths"));
        int assists     = Integer.parseInt(req.getParameter("assists"));
        String memo     = req.getParameter("memo");

        // DTO에 담기
        GameRecordDto record = new GameRecordDto();
        record.setUserId(loginUser.getId());
        record.setChampion(champion);
        record.setResult(result);
        record.setKills(kills);
        record.setDeaths(deaths);
        record.setAssists(assists);
        record.setMemo(memo);

        // DB 저장
        int saveResult = gameRecordDao.insert(record);

        if (saveResult > 0) {
            resp.sendRedirect(req.getContextPath() + "/record/list");
        } else {
            req.setAttribute("error", "전적 저장에 실패했습니다.");
            req.getRequestDispatcher("/record_form.jsp").forward(req, resp);
        }
    }
}