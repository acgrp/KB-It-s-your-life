package org.edu.servletproject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// /example1으로 요청 시 해당 서블릿이 처리할 수 있도록 매핑 작성

// Servlet 클래스 만들 때 반드시 HttpServlet 상속 받아야 함!

@WebServlet(name = "servletEx1", value = "/example1")
public class ServletEx1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // 요청 시 전달된 input 태그 값(== Parameter)을 얻어오는 방법
        // req.getParameter("input태그 name 속성 값")
//        System.out.println(req.getParameter("name"));
//        System.out.println(req.getParameter("age"));
        String name = req.getParameter("name");
        String age = req.getParameter("age");

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<h1>이름 : " + name + "</h1>");
        out.println("<h1>나이 : " + age + "</h1>");
        out.println("</body></html>");

    }
}
