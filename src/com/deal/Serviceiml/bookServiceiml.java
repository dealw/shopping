package com.deal.Serviceiml;

import com.deal.Dao.bookDao;
import com.deal.Daoiml.Daoiml;
import com.deal.Service.bookService;
import com.deal.entity.book;

import java.util.List;
import java.util.Map;

public class bookServiceiml implements bookService {
    @Override
    public List<book> queryAllbook() {
        bookDao dao=new Daoiml();
        return dao.queryAllbook();
    }

    @Override
    public List<book> queryAllCartbook() {
        bookDao dao=new Daoiml();
        return dao.queryAllCartbook();
    }

    @Override
    public boolean buybook(int bno) {
        return false;
    }

    @Override
    public book querybookBybno(int bno) {
        bookDao dao=new Daoiml();
        return dao.querybookBybno(bno);
    }

    @Override
    public boolean addCart(book carbook) {
        bookDao dao=new Daoiml();
        return dao.addCart(carbook);
    }

    @Override
    public boolean deleteCart(int bno) {
        bookDao dao=new Daoiml();
        return dao.deleteCart(bno);
    }

    @Override
    public boolean deleteAllCart() {
        bookDao dao=new Daoiml();
        return dao.deleteAllCart();
    }

    @Override
    public boolean deleteStore(int bno,int store) {
        bookDao dao=new Daoiml();
        return dao.deleteStore(bno,store);
    }

    @Override
    public boolean addStore(int bno, int store) {
        bookDao dao=new Daoiml();
        return dao.addStore(bno,store);
    }

    @Override
    public int queryStore(int bno) {
        bookDao dao=new Daoiml();
        return dao.queryStore(bno);
    }

    @Override
    public Map queryCartStore() {
        bookDao dao=new Daoiml();
        return dao.queryCartStore();
    }

    @Override
    public List<book> getBookByPage(int page, int amount) {
        bookDao dao=new Daoiml();
        return dao.getBookByPage(page,amount);
    }

    @Override
    public int gettotalpage() {
        bookDao dao=new Daoiml();
        return dao.gettotalpage();
    }

    @Override
    public boolean addshop(book b) {
        bookDao dao=new Daoiml();
        if(dao.querybookBybno(b.getBno())!=null){
            return false;
        }else {
            return dao.addshop(b);
        }
    }

    @Override
    public boolean deleteshop(int bno) {
        bookDao dao=new Daoiml();
        if(dao.querybookBybno(bno)==null){
            return false;
        }else {
            return dao.deleteshop(bno);
        }
    }


}
