package com.deal.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DBUtil {
    private static final String URL="jdbc:sqlserver://localhost:1433;databasename=book";
    private static final String NAME="sa";
//    增删改
public static Connection connection;
public static PreparedStatement pstmt;
    public static boolean executeUpdate(String sql,Object param[]){
        try {
            connection= getConnection();
            pstmt=connection.prepareStatement(sql);
            if(param!=null) {
                for (int i = 0;i<param.length;i++){
                    pstmt.setObject(i+1,param[i]);
                }
            }
            final int flag = pstmt.executeUpdate();
            if(flag>0){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeAll(null,pstmt,connection);
        }
}
//查找
    public static ResultSet queraryInf(String sql,Object[] param){
        try {
//            String  sql="select * from bookinf";
            connection=getConnection();
            pstmt=connection.prepareStatement(sql);
            if(param!=null) {
                for (int i = 0;i<param.length;i++){
                    pstmt.setObject(i+1,param[i]);
                }
            }
            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }


    }
//获取连接
public static Connection getConnection() throws SQLException, ClassNotFoundException, SQLException {
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    return DriverManager.getConnection(URL,NAME,"159357www");
}
//关闭连接
    public static void closeAll(ResultSet rs,PreparedStatement pstmt,Connection connection ) {
        try {
            if(rs!=null)rs.close();
            if(pstmt!=null)pstmt.close();
            if(connection!=null)connection.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getInfByPage(int a, int b) {
        ResultSet rs=null;
        try {
            connection = getConnection();
            String sql="select * from (select *, ROW_NUMBER() OVER(Order by bno ) AS RowId from bookinf) as b where RowId between ? and ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, a);
            pstmt.setInt(2, b);
            rs = pstmt.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return rs;

    }
}
