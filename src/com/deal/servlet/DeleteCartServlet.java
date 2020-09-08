package com.deal.servlet;

import com.deal.Service.bookService;
import com.deal.Serviceiml.bookServiceiml;
import com.deal.entity.book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/DeleteCartServlet")
public class DeleteCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        int bno = Integer.parseInt(request.getParameter("bno"));
        bookService service = new bookServiceiml();
        boolean flag = service.deleteCart(bno);
        if (flag) {
            int store = service.queryStore(bno);
            boolean flag1 = service.addStore(bno,store);
            if(flag1) {
                Map<Integer, Integer> map=service.queryCartStore();
                List<book> cartbook = service.queryAllCartbook();
                if (!cartbook.isEmpty()) {
                    request.setAttribute("cartbook", cartbook);
                    request.setAttribute("map", map);
                    request.getRequestDispatcher("/Myjsp/cart.jsp").forward(request, response);
                } else {
                    response.getWriter().print("购物车里没东西快去<a href='AllBookServlet'>添加</a>吧！");
                }
            }else {
                response.getWriter().print("删除失败!");
            }
        }
    }
}
