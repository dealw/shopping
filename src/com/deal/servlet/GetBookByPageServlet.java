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
import java.io.IOException;
import java.util.List;

@WebServlet("/GetBookByPageServlet")
public class GetBookByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        bookService bs = new bookServiceiml();
        String page = request.getParameter("page");
        int p=Integer.parseInt(page);
        if(p==0||p>bs.gettotalpage()||page==null){
            p=1;
        }
        List<book> bookByPage = bs.getBookByPage(p, 4);
        pageUtil pa=new pageUtil(bookByPage,p);
        if(bookByPage!=null) {
            request.setAttribute("pageBookinf",pa);
            request.getRequestDispatcher("/Myjsp/hallwithoutpagecount.jsp").forward(request, response);
        }else {
            response.getWriter().print("没有商品！");
        }
    }
}
