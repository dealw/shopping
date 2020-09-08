package com.deal.entity;

public class book {
    private int bno;
    private String bname;
    private int bstore;
    private int bprice;
    public book(){

    }
    public book(int bno, String bname, int bstore, int bprice) {
        this.bno = bno;
        this.bname = bname;
        this.bstore = bstore;
        this.bprice = bprice;
    }
    public book(int bno,String bname,int bprice){
        this.bno = bno;
        this.bname = bname;
        this.bprice = bprice;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public int getBstore() {
        return bstore;
    }

    public void setBstore(int bstore) {
        this.bstore = bstore;
    }

    public int getBprice() {
        return bprice;
    }

    public void setBprice(int bprice) {
        this.bprice = bprice;
    }
}
