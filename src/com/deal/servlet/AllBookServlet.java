package com.deal.servlet;

import com.deal.Service.bookService;
import com.deal.Serviceiml.bookServiceiml;
import com.deal.entity.book;
import com.deal.pageUtil.pageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Service;
import java.io.IOException;
import java.util.List;

@WebServlet("/AllBookServlet")
public class AllBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        bookService bs = new bookServiceiml();
        List<book> bls = bs.getBookByPage(1,4);
        pageUtil pa=new pageUtil(bls,1);
        if (pa.getBook()!=null) {
            request.setAttribute("pageBookinf",pa);
            request.getRequestDispatcher("/Myjsp/hall.jsp").forward(request, response);
        } else {
            response.getWriter().print("没有商品！");
        }
    }
}
