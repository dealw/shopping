package com.deal.pageUtil;
import com.deal.entity.book;
import java.util.List;
public class pageUtil {
    private List<book> book;
   private int page;
    public pageUtil() {

    }
    public pageUtil(List<book> book, int page) {
        this.book = book;
        this.page = page;
    }
    public List<book> getBook() {
        return book;
    }
    public void setBook(List<book> book) {
        this.book = book;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
}
