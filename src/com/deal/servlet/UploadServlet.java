package com.deal.servlet;
import com.deal.Service.bookService;
import com.deal.Serviceiml.bookServiceiml;
import com.deal.entity.book;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet("/Myjsp/UploadServlet")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        boolean multipartContent = ServletFileUpload.isMultipartContent(request);
        try {
            if(multipartContent) {
                int bno=-1;
                int price=-1;
                int bum=-1;
                String bname=null;
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload=new ServletFileUpload(factory);
                ((DiskFileItemFactory) factory).setSizeThreshold(70000);
                ((DiskFileItemFactory) factory).setRepository(new File("D:\\study"));
                upload.setSizeMax(102400);
                List<FileItem> items=upload.parseRequest(request);
                Iterator<FileItem> ite=items.iterator();
                while(ite.hasNext()) {
                    FileItem item=ite.next();
                    String itename=item.getFieldName();
                    if(item.isFormField()) {//获取表单数据
                        if(itename.equals("bno")) {
                            bno=Integer.parseInt(item.getString());
                        }else if(itename.equals("bname")) {
                            bname=item.getString("utf-8");
                        }else if(itename.equals("bprice")){
                            price=Integer.parseInt(item.getString());
                        }else if(itename.equals("bnum")){
                            bum=Integer.parseInt(item.getString());
                        }
                    }else {//上传文件
                        String filename=item.getName();
                        String last=filename.substring(filename.indexOf(".")+1);
                        if(last.equals("")){
                            continue;
                        }
                        if(last.equals("png")){
                        File file=new File("D:\\uploadtest\\new",bno+".png");
                        item.write(file);
                        }else {
                            response.getWriter().print(filename+"此格式不支持");
                            return;
                        }
                    }
                }
                book book=new book(bno,bname,bum,price);
                bookService bs = new bookServiceiml();
                boolean flag = bs.addshop(book);
                int f=1;
                if(!flag){
                    f=-1;
                }
                request.setAttribute("flag",f);
                request.setAttribute("bname",bname);
                request.setAttribute("store",bum);
                request.setAttribute("bno",bno);
                request.setAttribute("price",price);
                request.getRequestDispatcher("/Myjsp/newaddsuccess.jsp").forward(request,response);
                return;
            }
        }catch(FileUploadBase.SizeLimitExceededException e){
            response.getWriter().print("文件过大");
        }
        catch (FileUploadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
