package com.wj.GoodsShow.Controller;

import com.alibaba.fastjson.JSONObject;
import com.wj.GoodsShow.Service.GoodsService;
import com.wj.GoodsShow.entity.Goods;
import org.apache.commons.fileupload.FileItem;
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
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/*
    goodsList/delete
    goodsList/add
 */
@WebServlet(urlPatterns = "/goodsList/*")
public class GoodsController extends HttpServlet {
    private static GoodsService goodsService = new GoodsService();
    //创建表单处理条目的工厂
    private static DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
    //apache给我们提供的文件上传的工具类,里边有可用的方法
    private static ServletFileUpload servletFileUpload;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestURI = req.getRequestURI();
        String action = requestURI.substring(requestURI.lastIndexOf("/"));
        JSONObject jsonObject = new JSONObject();
        HashMap<Object, Object> hashMap = new HashMap<>();
        if (action.equals("/delete")) {
            String id = req.getParameter("id");
            Integer page = Integer.parseInt(req.getParameter("page"));
            try {
                deleteGood(id);
                goodsService.pageAll(page, 5);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Integer countNum = goodsService.currentNum();
            //页数调整
            if (countNum == 0) {
                page = (page != 1) ? page - 1 : page;
            }
            jsonObject.put("page", page);
            jsonObject.put("code", 666);
            jsonObject.put("message", "OK");
            resp.setContentType("application/json");
            resp.getWriter().write(jsonObject.toJSONString());
        } else if (action.equals("/addGoods")) {
            try {
                addGood(req);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("文件上传失败");
            }
            try {
                Integer countNum = goodsService.countNum();
                int pages = (int) Math.ceil(countNum * 1.0 / 5);
                //总页码
                hashMap.put("pages", pages);
                //当前页码
                hashMap.put("current", 1);
                //获得本页所有商品
                hashMap.put("GoodsList", goodsService.pageAll(1, 5));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.getSession().setAttribute("ResultMap", hashMap);
            resp.sendRedirect("/GoodsList.jsp");
        } else if (action.equals("/getGood")) {
            Goods good = null;
            try {
                good = getGood(req, resp);
            } catch (SQLException | ServletException e) {
                e.printStackTrace();
            }
            req.getSession().setAttribute("good", good);
            resp.sendRedirect("/replaceGoods.jsp");
        } else if (action.equals("/replace")) {
            try {
                replaceGood(req);
                Integer countNum = goodsService.countNum();
                int pages = (int) Math.ceil(countNum * 1.0 / 5);
                //总页码
                hashMap.put("pages", pages);
                //当前页码
                hashMap.put("current", 1);
                //获得本页所有商品
                hashMap.put("GoodsList", goodsService.pageAll(1, 5));
            } catch (Exception e) {
                e.printStackTrace();
            }
            req.getSession().setAttribute("ResultMap", hashMap);
            resp.sendRedirect("/GoodsList.jsp");
        }
    }

    public void deleteGood(String id) throws SQLException {
        String result = goodsService.deleteById(id);
        if (result != null && result.equals("0")) {
            System.out.println("删除失败");
        }
    }

    public void addGood(HttpServletRequest req) throws Exception {

        //对于请求中的二进制的数据,getParam是拿不到的,就要用apache的一个工具类
        servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        //parseRequest(req):能够解析请求,fileItems里边存放的是  普通表单条目+文件的表单条目
        List<FileItem> fileItems = servletFileUpload.parseRequest(req);
        HashMap<String, Object> hashMap = new HashMap<>();
        Goods goods = new Goods();
        for (FileItem fileItem : fileItems) {
            //如果是普通文件条目
            if (fileItem.isFormField()) {
                //普通条目
                String fieldName = fileItem.getFieldName();
                //条目值
                String value = fileItem.getString("utf-8");
                hashMap.put(fieldName, value);
                //System.out.println("普通条目:   fieldName: " + fieldName + "String: " + string);
            } else {
                String fieldName = fileItem.getFieldName();
                String name = fileItem.getName();
                String fileName = UUID.randomUUID().toString() + name;
                String realPath = this.getServletContext().getRealPath("/upload");
                File file = new File(realPath);
                //创建目录(可以生成多级目录)
                file.mkdirs();
                //创建文件类
                File file1 = new File(realPath + "/" + fileName);
                //将这个文件写入到指定路径中
                fileItem.write(file1);
                hashMap.put(fieldName, "/upload/" + fileName);
            }
        }
        String title = (String) hashMap.get("title");
        long price = Long.parseLong(String.valueOf(hashMap.get("price")));
        String image = (String) hashMap.get("image");
        String description = (String) hashMap.get("description");

        //添加商品
        goodsService.addGoods(title, description, price, image);
    }

    public void listAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Goods> goodsList = null;
        try {
            goodsList = goodsService.listAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("GoodsList", goodsList);
        //请求转发,还是同一个请求,属性转发到jsp页面还存在,属于一次请求
        req.getRequestDispatcher("/GoodsList.jsp").forward(req, resp);
    }

    public Goods getGood(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String id = req.getParameter("id");
        return goodsService.getGood(id);
    }

    public void replaceGood(HttpServletRequest req) throws Exception {

        //对于请求中的二进制的数据,getParam是拿不到的,就要用apache的一个工具类
        servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        //parseRequest(req):能够解析请求,fileItems里边存放的是  普通表单条目+文件的表单条目
        List<FileItem> fileItems = servletFileUpload.parseRequest(req);
        HashMap<String, Object> hashMap = new HashMap<>();
        for (FileItem fileItem : fileItems) {
            if (fileItem.isFormField()) {
                String fieldName = fileItem.getFieldName();
                String value = fileItem.getString("utf-8");
                hashMap.put(fieldName, value);
            } else {
                String fieldName = fileItem.getFieldName();
                String name = fileItem.getName();
                String fileName = UUID.randomUUID().toString() + name;
                String realPath = this.getServletContext().getRealPath("/upload");
                File file = new File(realPath);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file1 = new File(realPath + "/" + fileName);
                fileItem.write(file1);
                hashMap.put(fieldName, "/upload/" + fileName);
            }
        }
        String id = (String) hashMap.get("id");
        String title = (String) hashMap.get("title");
        long price = Long.parseLong(String.valueOf(hashMap.get("price")));
        String image = (String) hashMap.get("image");
        String description = (String) hashMap.get("description");

        //修改商品
        System.out.println(goodsService.replaceGood(id, title, description, price, image));
    }
}
