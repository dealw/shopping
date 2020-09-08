package com.deal.servlet;

import com.deal.Service.bookService;
import com.deal.Serviceiml.bookServiceiml;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Myjsp/ManagerServlet")
public class ManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
        int bno = Integer.parseInt(request.getParameter("bno"));
        int bnum = Integer.parseInt(request.getParameter("bnum"));
        bookService service = new bookServiceiml();
        for(int i=0;i<bnum;i++) {
            int store = service.queryStore(bno);
            service.addStore(bno, store);
        }
        int store = service.queryStore(bno);
        request.setAttribute("store",store);
        request.setAttribute("bno",bno);
        request.getRequestDispatcher("/Myjsp/addsuccess.jsp").forward(request,response);
    }
}
