package com.deal.Dao;

import com.deal.entity.book;

import java.util.List;
import java.util.Map;

public interface bookDao {
    public List<book> queryAllbook();
    public List<book> queryAllCartbook();
    public book querybookBybno(int bno);
    public boolean isExist(int bno);
    public boolean buybook(int bno);
    public boolean addCart(book carbook);
    public boolean deleteCart(int bno);
    public boolean deleteAllCart();
    public boolean deleteStore(int bno,int store);
    public int queryStore(int bno);
    public boolean addStore(int bno,int store);
    public Map queryCartStore();
    public List<book> getBookByPage(int page,int amount);
    public int gettotalpage();
    public boolean addshop(book b);
    public boolean deleteshop(int bno);
}
