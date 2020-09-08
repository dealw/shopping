package com.deal.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Myjsp/CheckLogServlet")
public class CheckLogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String uname = request.getParameter("uname");
        String upwd =  request.getParameter("upwd");
        if(uname.equals("deal")&&upwd.equals("159357www")){
            response.sendRedirect("Manager.jsp");
            return;
        }else {
            String str = "用户名或密码错误";
            request.setAttribute("str", str);
            request.getRequestDispatcher("/Myjsp/login.jsp").forward(request, response);
        }
    }
}
