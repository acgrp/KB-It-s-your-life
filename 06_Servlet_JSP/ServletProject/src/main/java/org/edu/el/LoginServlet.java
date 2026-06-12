package org.edu.el;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/el/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();


        String userid = req.getParameter("userid");
        String passwd = req.getParameter("passwd");

        //전달 받은 값 attribute에 세팅

        req.setAttribute("id", userid);
        req.setAttribute("pw", passwd);

        req.getRequestDispatcher("/el/login.jsp").forward(req,resp);


    }
}
