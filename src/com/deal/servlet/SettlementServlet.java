package com.deal.servlet;

import com.deal.Service.bookService;
import com.deal.Serviceiml.bookServiceiml;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/SettlementServlet")
public class SettlementServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        bookService service = new bookServiceiml();
        Map<Integer, Integer> map=service.queryCartStore();
        int total = Integer.parseInt(request.getParameter("total"));
        boolean flag = service.deleteAllCart();
        if (flag) {
            if (total == 0) {
                for(int bno:map.keySet()){
                    for(int j=0;j<map.get(bno);j++) {
                        int store = service.queryStore(bno);
                        service.addStore(bno, store);
                    }
                }
                request.getRequestDispatcher("/Myjsp/deletecart.jsp").forward(request, response);
                return;
            }
            request.setAttribute("total", total);
            request.getRequestDispatcher("/Myjsp/total.jsp").forward(request, response);
            return;
        } else {
            response.getWriter().print("清空失败!");
        }
    }
}
