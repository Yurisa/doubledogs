package com.servlet;

import java.io.*;
import java.util.ArrayList;

import com.alibaba.fastjson.JSONObject;
import com.util.HttpHelper;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.json.JSONArray;

/**
 * Created by Yurisa on 2017/6/12.
 */
@WebServlet("/ajaxupload")
public class AjaxUploadServlet extends AutowiredHttpServlet {
   String companyId;
   String companyName;
   String link;
    @Override
        @SuppressWarnings("deprecation")
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
       protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           JSONObject json = new JSONObject();
           String path;
           String savePath = getServletContext().getRealPath("/images/upload");
//           System.out.println(savePath);
          if (ServletFileUpload.isMultipartContent(req)) {
              List<FileItem> items = null;
              try {
                  items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req);
              } catch (FileUploadException e) {
                  e.printStackTrace();
              }
              if (items != null && items.size() > 0) {
            for (FileItem item : items) {
                if (!item.isFormField()) {// 过滤掉非文件域
                    String fileType = item.getName().substring(item.getName().lastIndexOf(".") + 1).toLowerCase();
                    String fileName = System.currentTimeMillis() + "." + fileType;
                    String file = savePath + "/" + fileName;
                    file = file.replaceAll("\\\\", "\\\\\\\\");
                    path =  "images/upload/" + fileName;
                    BufferedInputStream in = new BufferedInputStream(item.getInputStream());
                    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(file)));
                    Streams.copy(in, out, true);// 把文件写到指定文件夹
                    in.close();
                    out.close();
                    json.put("path",path);
//                    System.out.println(pathlist);
                } else {
                    String name = new String(item.getFieldName().getBytes("iso-8859-1"), "utf-8");
                    String val = new String(item.getString().getBytes("iso-8859-1"), "utf-8");
                    if (name.equals("f_id")) {
                        companyId = val.split("-")[0];
                        companyName = val.split("-")[1];
                    } else if (name.equals("link")) {
                        link = val;
                    }
                }
            }
//            new DBUtil().executeUpdate("insert into sc_slide(company_id,plot,href,path) values(?,?,?,?)",
//                    new String[]{companyId, companyName, link, path});
//            HttpHelper.build().setCode(200).setResult(path).response(resp);

                 json.put("success",1);

                  responseJSON(resp,json.toString());
        } else {
            HttpHelper.build().setCode(110).setResult("没有选择文件").response(resp);
        }
    } else {
        HttpHelper.build().setCode(110).setResult("表单必须包含enctype=multipart/form-data").response(resp);
    }



}}

