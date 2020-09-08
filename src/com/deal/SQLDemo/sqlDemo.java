package com.deal.SQLDemo;

import java.sql.*;
import java.util.Scanner;

public class sqlDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=book","sa","159357www");
        Statement sta = conn.createStatement();
        Scanner in=new Scanner(System.in);
        System.out.println("请输入用户名");
        String name=in.nextLine();
        System.out.println("请输入密码");
        String pwd=in.nextLine();
        String sql="select count(*) from login where name='asdasdasd ' or 1=1 --' and pwd='"+pwd+"'";
        ResultSet rs = sta.executeQuery(sql);
        int flag=-1;
        if(rs.next()){
           flag=rs.getInt(1);
        }if(flag>0){
            System.out.println("登陆成功！");
        } else {
            System.out.println("登陆失败!");
        }
    }
}
