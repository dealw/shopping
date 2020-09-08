package com.deal.Service;

import com.deal.entity.book;

import java.util.List;
import java.util.Map;


public interface bookService {
    public List<book> queryAllbook();
    public List<book> queryAllCartbook();
    public boolean buybook(int bno);
    public book querybookBybno(int bno);
    public boolean addCart(book carbook);
    public boolean deleteCart(int bno);
    public boolean deleteAllCart();
    public boolean deleteStore(int bno,int store);
    public boolean addStore(int bno,int store);
    public int queryStore(int bno);
    public Map queryCartStore();
    public List<book> getBookByPage(int page, int amount);
    public int gettotalpage();
    public boolean addshop(book b);
    public boolean deleteshop(int bno);
}
