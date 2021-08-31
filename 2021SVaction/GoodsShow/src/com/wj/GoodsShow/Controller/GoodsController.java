package com.wj.GoodsShow.Controller;

import com.alibaba.fastjson.JSONObject;
import com.wj.GoodsShow.Service.GoodsService;
import com.wj.GoodsShow.entity.Goods;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        } else if (action.equals("/addGoods")) {
            try {
                addGood(req);
            } catch (SQLException | FileUploadException e) {
                e.printStackTrace();
            }
        }
        resp.getWriter().write(jsonObject.toJSONString());
    }

    public static void deleteGood(String id) throws SQLException {
        String result = goodsService.deleteById(id);
        if (result != null && result.equals("0")) {
            System.out.println("删除失败");
        }
    }

    public static void addGood(HttpServletRequest req) throws SQLException, FileUploadException {

        //对于请求中的二进制的数据,getParam是拿不到的,就要用apache的一个工具类
        servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        //parseRequest(req):能够解析请求,fileItems里边存放的是  普通表单条目+文件的表单条目
        List<FileItem> fileItems = servletFileUpload.parseRequest(req);
        HashMap<Object, Object> hashMap = new HashMap<>();
        for (FileItem fileItem : fileItems) {
            //如果是普通文件条目
            if (fileItem.isFormField()) {
                //普通条目
                String fieldName = fileItem.getFieldName();
                //条目值
                String string = fileItem.getString();
                System.out.println("普通条目:   fieldName: " + fieldName + "String: " + string);
            }else {
                String fieldName = fileItem.getFieldName();
                String name = fileItem.getName();
                System.out.println("文件条目:   fieldName: " + fieldName + "name: " + name);
                String string = UUID.randomUUID().toString();
            }
        }
    }

    public static void listAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
}
