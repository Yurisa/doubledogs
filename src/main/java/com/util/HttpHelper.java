package com.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by huang on 2017/3/6.
 */
public class HttpHelper {

    private JSONObject responseBody;

    private HttpHelper() {
        responseBody = new JSONObject();
    }

    public static HttpHelper build() {
        return new HttpHelper();
    }

    public HttpHelper setCode(int code) {
        responseBody.put("code", code);
        switch (code) {
            case 200: //成功
                responseBody.put("result", "请求成功");
                break;
            case 401: //未授权
                responseBody.put("result", "登录失效,请重新登录");
                break;
            case 404: //未找到
                responseBody.put("result", "请求的方法不存在");
                break;
            case 428: //要求先决条件
                responseBody.put("result", "请求参数缺失");
                break;
            case 503: //服务不可用
                responseBody.put("result", "服务器异常,请稍后再试");
                break;
        }
        return this;
    }

    public HttpHelper setResult(String result) {
        responseBody.put("result", result);
        return this;
    }

    public <T> HttpHelper setData(T data) {
        responseBody.put("data", data);
        return this;
    }

    public void response(HttpServletResponse resp) {
        try {
            resp.setCharacterEncoding("utf-8");
            PrintWriter writer = resp.getWriter();
            writer.print(JSON.toJSONString(responseBody));
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
