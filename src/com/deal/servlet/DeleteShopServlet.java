package com.deal.servlet;

import com.deal.Service.bookService;
import com.deal.Serviceiml.bookServiceiml;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Myjsp/DeleteShopServlet")
public class DeleteShopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            int  bno = Integer.parseInt(request.getParameter("bno"));
            bookService service = new bookServiceiml();
            boolean flag = service.deleteshop(bno);
            if(!flag){
                response.getWriter().print("删除失败，该书不存在！");
                response.getWriter().print("页面三秒钟后跳转,");
                response.setHeader("refresh", "3;url=../GetBookByPageServlet?page=1");
                response.getWriter().print("如果没有跳转，请点击<a href='GetBookByPageServlet?page=1'>这里</a>");
            }else {
                response.getWriter().print("删除成功！");
                response.getWriter().print("页面三秒钟后跳转,");
                response.setHeader("refresh", "3;url=../GetBookByPageServlet?page=1");
                response.getWriter().print("如果没有跳转，请点击<a href='GetBookByPageServlet?page=1'>这里</a>");
            }
    }
}
