package com.deal.Daoiml;

import com.deal.DBUtil.DBUtil;
import com.deal.Dao.bookDao;
import com.deal.entity.book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Daoiml implements bookDao {
    @Override
    public List<book> queryAllbook() {
        List<book> ls=new ArrayList<>();
        ResultSet rs=null;
        String sql="select * from bookinf";
        try {
            rs=DBUtil.queraryInf(sql,null);
            while(rs.next()){
                int bno=rs.getInt("bno");
                String bname=rs.getString("bname");
                int bstore=rs.getInt("bstore");
                int bprice=rs.getInt("bprice");
                book bk=new book(bno,bname,bstore,bprice);
                ls.add(bk);
            }return ls;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
        }
    }

    @Override
    public Map queryCartStore(){
        Map<Integer, Integer> map=new HashMap<Integer,Integer>();
        ResultSet rs=null;
        String sql="select bno,COUNT(*) as bstore from cart group by bno";
        rs=DBUtil.queraryInf(sql,null);

            try {
                while (rs.next()) {
                    int bno=rs.getInt("bno");
                    int bstore = rs.getInt("bstore");
                    map.put(bno,bstore);
                }return map;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }catch(Exception e){
                e.printStackTrace();
            return null;
            }finally {
                DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
            }
    }

    @Override
    public List<book> getBookByPage(int page, int amount) {
        List<book> pageofbooks=new ArrayList<>();
        ResultSet rs=null;
        rs=DBUtil.getInfByPage((page-1)*amount+1, page*amount);
        try {
            while(rs.next()) {
                int bno=rs.getInt("bno");
                String bname=rs.getString("bname");
                int bstore=rs.getInt("bstore");
                int bprice=rs.getInt("bprice");
                book bk=new book(bno,bname,bstore,bprice);
                pageofbooks.add(bk);
            }
            return pageofbooks;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.closeAll(rs, DBUtil.pstmt,DBUtil.connection);
        }
    }

    @Override
    public int gettotalpage() {
        int tp;
        ResultSet rs=null;
        String sql="select count(1) from bookinf";
        try{
            rs=DBUtil.queraryInf(sql,null);
            if(rs.next()){
                tp=rs.getInt(1);
                if(tp%4==0){
                    return tp/4;
                }else {
                  return tp/4+1;
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
        }
            return 0;
    }

    @Override
    public boolean addshop(book b) {
        String sql="insert into bookinf values(?,?,?,?)";
        Object [] param={b.getBno(),b.getBname(),b.getBstore(),b.getBprice()};
        return DBUtil.executeUpdate(sql,param);
    }

    @Override
    public boolean deleteshop(int bno) {
        String sql="delete from bookinf where bno=?";
        Object [] param={bno};
        return DBUtil.executeUpdate(sql,param);
    }

    public List<book> queryAllCartbook() {
        List<book> ls=new ArrayList<>();
        ResultSet rs=null;
        String sql="select distinct bno,bname,bprice from cart";
        try {
            rs=DBUtil.queraryInf(sql,null);
            while(rs.next()){
                int bno=rs.getInt("bno");
                String bname=rs.getString("bname");
                int bprice=rs.getInt("bprice");
                book bk=new book(bno,bname,bprice);
                ls.add(bk);
            }return ls;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
        }
    }



    @Override
    public book querybookBybno(int bno) {
        ResultSet rs=null;
        String sql="select * from bookinf where bno=?";
        Object [] param={bno};
            try {
                rs=DBUtil.queraryInf(sql,param);
                if(rs.next()) {
                    String bname = rs.getString("bname");
                    int bprice = rs.getInt("bprice");
                    book book=new book(bno,bname,bprice);
                    return book;
                }return null;
            } catch (SQLException e) {
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
            }
        return null;
    }

    @Override
    public boolean isExist(int bno) {
        return false;
    }

    @Override
    public boolean buybook(int bno) {
        return false;
    }

    @Override
    public boolean addCart(book carbook) {
        String sql="insert into cart values(?,?,?)";
        Object [] param={carbook.getBno(),carbook.getBname(),carbook.getBprice()};
        return DBUtil.executeUpdate(sql,param);
    }

    @Override
    public boolean deleteCart(int bno) {
        String sql="delete from cart where id in(select MAX(id) from cart where id in(select id  from cart where  bno=? and exists(SELECT  MAX(id),bno FROM cart GROUP BY bno)))";
        Object[] param={bno};
        return DBUtil.executeUpdate(sql,param);
    }

    @Override
    public boolean deleteAllCart() {
        String sql="delete from cart ";
        return DBUtil.executeUpdate(sql,null);
    }

    @Override
    public boolean deleteStore(int bno,int store) {
        int afstore=store-1;
        String sql="UPDATE bookinf set bstore=? where bno=?";
        Object [] param={afstore,bno};
        return DBUtil.executeUpdate(sql,param);
    }

    @Override
    public int queryStore(int bno) {
        String sql="select bstore from bookinf where bno=?";
        Object [] param={bno};
        ResultSet rs=null;
        try {
            rs = DBUtil.queraryInf(sql,param);
            if(rs.next()){
                int story = rs.getInt("bstore");
               return story;
            }return -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }catch(Exception e){
            e.printStackTrace();
            return  -1;
        }
    }

    @Override
    public boolean addStore(int bno, int store) {
        int afstore=store+1;
        String sql="UPDATE bookinf set bstore=? where bno=?";
        Object [] param={afstore,bno};
        return DBUtil.executeUpdate(sql,param);
    }


}
