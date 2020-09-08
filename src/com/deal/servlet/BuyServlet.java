package com.deal.servlet;

import com.deal.Service.bookService;
import com.deal.Serviceiml.bookServiceiml;
import com.deal.entity.book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Service;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        int bno = Integer.parseInt(request.getParameter("bno"));
        bookService service = new bookServiceiml();
        book book = service.querybookBybno(bno);
        if (book != null) {
            int store = service.queryStore(bno);
            if (store < 1) {
                response.getWriter().print("没有库存啦!");
                response.getWriter().write("请回<a href='AllBookServlet'>首页</a>");
                return;
            }
            service.addCart(book);
            boolean flag1 = service.deleteStore(bno, store);
            if (flag1) {
                Map<Integer, Integer> map = service.queryCartStore();
                List<com.deal.entity.book> cartbook = service.queryAllCartbook();
                if (!cartbook.isEmpty()) {
                    request.setAttribute("cartbook", cartbook);
                    request.setAttribute("map", map);
                    request.getRequestDispatcher("/Myjsp/cart.jsp").forward(request, response);
                } else {
                    response.getWriter().print("购买失败!");
                }
            }
        }
    }
}

