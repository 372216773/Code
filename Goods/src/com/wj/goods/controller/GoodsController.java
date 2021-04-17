package com.wj.goods.controller;

import com.alibaba.fastjson.JSON;
import com.wj.goods.entity.Good;
import com.wj.goods.service.GoodsService;
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

@WebServlet("/goods/*")
public class GoodsController extends HttpServlet {


    GoodsService goodsService = new GoodsService();
    //创建表单处理条目的工厂
    DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
    //apache给我们提供的文件上传的工具类,里边有可用的方法
    ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得URI
        String requestURI = req.getRequestURI();

        if (requestURI.contains("/delete")) {
            delete(req, resp);
        }
        //将要修改的商品数据导入到修改页
        if (requestURI.contains("/replace")) {

            try {
                replace(req, resp);
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }

        }
        //导入数据库
        if (requestURI.contains("/update")) {
            try {
                updateGoods(req, resp);
            } catch (Exception throwable) {
                throwable.printStackTrace();
            }
        }
        if (requestURI.contains("/add")) {

            try {
                insert(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (requestURI.contains("/page")) {
            page(req, resp);
        }
        if (requestURI.contains("/search")) {
            try {
                search(req, resp);
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public void page(HttpServletRequest req, HttpServletResponse resp) {
        //当前页码
        int currentPage = Integer.parseInt(req.getParameter("currentPage"));
        //每页显示数目
        int size = Integer.parseInt(req.getParameter("size"));
        try {
            //总商品数
            int total = goodsService.countGoods();

            //总页数
            int totalPage = (int) Math.ceil(total * 1.0 / size);

            //单页所有商品
            List<Good> goodList = goodsService.listThisPageAll(currentPage, size);

            LinkedHashMap<Object, Object> map = new LinkedHashMap<>();

            //所要传的数据
            map.put("currentPage", currentPage);
            map.put("totalPage", totalPage);
            map.put("goodList", goodList);

            //把值给pageMap,jsp在pageMap中找值
            req.setAttribute("pageMap", map);
            req.getRequestDispatcher("/goods.jsp").forward(req, resp);
        } catch (SQLException | ServletException | IOException throwable) {
            throwable.printStackTrace();
        }
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        try {
            int i = goodsService.deleteGood(id);
            if (i > 0) {
                resp.getWriter().write("isDeleted");
            } else {
                resp.getWriter().write("error");
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void insert(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        //parseRequest(req):能够解析请求,fileItems里边存放的是  普通表单条目+文件的表单条目
        List<FileItem> fileItems = servletFileUpload.parseRequest(req);

        HashMap<String, String> map = new HashMap<>();

        for (FileItem fileItem : fileItems) {

            //普通条目
            if (fileItem.isFormField()) {
                map.put(fileItem.getFieldName(), fileItem.getString("utf8"));
            } else {

                //文件的表单条目
                //fileItem.getName();//上传上来的文件名
                String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "_" + fileItem.getName();
                String realPath = this.getServletContext().getRealPath("/upload");
                File realPathFile = new File(realPath);
                if (!realPathFile.exists()) {
                    realPathFile.mkdirs();
                }
                //获取上传文件的内容
                //InputStream inputStream = fileItem.getInputStream();
                //把文件写出到硬盘中
                File storeFile = new File(realPath + "/" + fileName);
                fileItem.write(storeFile);
                map.put(fileItem.getFieldName(), "/upload/" + fileName);
            }

        }

        String title = map.get("title");
        long price = Long.parseLong(map.get("price"));
        String image = map.get("image");
        goodsService.addGood(title, price, image);
        resp.sendRedirect("/goods/page?currentPage=1&size=5");

    }

    public void replace(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException, ServletException {

        String id = req.getParameter("id");
        Good good = findGood(id);
        req.setAttribute("good", good);

        req.getRequestDispatcher("/replaceGoods.jsp").forward(req, resp);
    }

    public Good findGood(String id) throws SQLException {

        return goodsService.findGood(id);

    }

    public void updateGoods(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        //parseRequest(req):能够解析请求,fileItems里边存放的是  普通表单条目+文件的表单条目
        List<FileItem> fileItems = servletFileUpload.parseRequest(req);

        HashMap<String, String> map = new HashMap<>();

        for (FileItem fileItem : fileItems) {

            //普通条目
            if (fileItem.isFormField()) {
                map.put(fileItem.getFieldName(), fileItem.getString("utf8"));
            } else {

                //文件的表单条目
                //fileItem.getName();//上传上来的文件名
                String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "_" + fileItem.getName();
                String realPath = this.getServletContext().getRealPath("/upload");
                File realPathFile = new File(realPath);
                if (!realPathFile.exists()) {
                    realPathFile.mkdirs();
                }
                //获取上传文件的内容
                //InputStream inputStream = fileItem.getInputStream();
                //把文件写出到硬盘中
                File storeFile = new File(realPath + "/" + fileName);
                fileItem.write(storeFile);
                map.put(fileItem.getFieldName(), "/upload/" + fileName);
            }

        }

        String id = map.get("id");
        String title = map.get("title");
        long price = Long.parseLong(map.get("price"));
        String image = map.get("image");

        int i = goodsService.updateGood(id, title, price, image);
        resp.sendRedirect("/goods/page?currentPage=1&size=5");
    }

    public void search(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        //当前页码
        //int currentPage = Integer.parseInt(req.getParameter("currentPage"));
        //每页显示数目
        //int size = Integer.parseInt(req.getParameter("size"));
        String title = req.getParameter("title");
        try {
            //总商品数
            int total = goodsService.countGoods();

            //总页数
            //int totalPage = (int) Math.ceil(total * 1.0 / size);

            //单页所有商品
            List<Good> goodList = goodsService.searchAll(title);

            LinkedHashMap<Object, Object> map = new LinkedHashMap<>();

            //所要传的数据
            //map.put("currentPage", currentPage);
            //map.put("totalPage", totalPage);
            map.put("goodList", goodList);
            req.setAttribute("goodMap", map);
            req.getRequestDispatcher("SearchGoods.jsp").forward(req, resp);

        }catch (SQLException | ServletException | IOException throwable) {
            throwable.printStackTrace();
        }
    }
}