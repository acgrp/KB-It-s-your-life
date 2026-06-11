package org.scoula.ex04.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cart_view_cookie")
public class CartViewCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html><body>");
        out.print("장바구니 리스트");

        Cookie[] cookie = req.getCookies();

        if(cookie != null){
            for(Cookie c : cookie){
                out.print(c.getName() + " : " + c.getValue() + "<br>");
            }

        }else{
            out.print("장바구니 비엇음<br>");
        }
        out.println("<a href = 'cookie_product.jsp'>상품 선택 페이지");
        out.println("<a href = 'cart_cookie_delete'>장바구니 비우기");
        out.print("</body></html>");

    }
}
