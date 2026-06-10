package org.edu.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PizzaOrder", value = "/pizza/order")
public class PizzaOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //RequestDispatcher : 요청 발송자
        // -> 지정된 JSP로 요청 정보(req), 응답 정보(resp)를 전송(발송)하는 역할

//        RequestDispatcher dispatcher = req.getRequestDispatcher("JSP경로);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/pizza_order.jsp");

        // forward : 전송하다, 보내나
        // -> JSP로 요청, 응답 보내기
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ** Post 방식 한글 깨짐 문제 **

        // - 데이터 전달 방식 차이점
        // GET : 주소(URL)를 통해서 데이터 전달
        //       이 때, 문자 인코딩은 제출된 HTML 파일의 문자 인코딩(charset)을 따름

        // POST : HTTP Body를 통해서 데이터 전달
        //        이 때, 문자 인코딩은 서버의 기본 문자 인코딩을 따름
        //        우리 서버(Tomcat) -> ISO-8859-1이 기본 문자 인코딩

        // * 해결 방법 *
        // - POST 방식으로 전달 받은 데이터의 문자 인코딩을 UTF-8로 변경
        req.setCharacterEncoding("UTF-8");

        String pizza = req.getParameter("pizza");
        String size = req.getParameter("size");
        int amount = Integer.parseInt(req.getParameter("amount"));

        //얻어온 파라미터 확인
        System.out.println("pizza : " + pizza);
        System.out.println("size : " + size);
        System.out.println("amount : " + amount);

        // 피자 이름, 가격 나누기
        String[] str =  pizza.split("-");
        String pizzaName = str[0];
        int price = Integer.parseInt(str[1]);
        if(size.equals("L")) price += 4000;

        //총가격 구하기
        price *= amount;

        System.out.println("pizza = " + pizza);
        System.out.println("pizzaCost = " + price);

        //L 사이즈인 경우 4000원 추가

        //JSP로 요청 위임
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/pizza_result.jsp");

        // JSP로 전달하는 req에는 파라미터가 담겨 있지만
        // Servlet에서 만든 pizzaName, price는 없다

        // * 해결 방법 *
        // req에 속성(Attribute)로 추가하면 JSP에서 꺼내 쓸 수 있다.
        // (주의!) forward 하기 전에 추가해야함!

        req.setAttribute("pizzaName", pizzaName);
        req.setAttribute("price", price);

        dispatcher.forward(req, resp);


    }
}
