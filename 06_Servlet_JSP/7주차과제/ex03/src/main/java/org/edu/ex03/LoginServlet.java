package org.edu.ex03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        String id = req.getParameter("userid");
        String pw = req.getParameter("passwd");

        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<h1>id : " + id + "</h1>");
        out.println("<h1>pw :  " + pw + "</h1>");
        out.println("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html;charset=UTF-8");

        String id = req.getParameter("userid");
        String pw = req.getParameter("passwd");

        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<h1>id : " + id + "</h1>");
        out.println("<h1>pw :  " + pw + "</h1>");
        out.println("</body></html>");
    }
}
