package top.mysecondgod.servlet.study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet 请求转发
 * 
 * @author zhaijw
 * 
 * 
 */
public class ServletReqDistationDemo extends HttpServlet
{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // response.getOutputStream().write("ServletReqDistationDemo".getBytes());
        // response.getWriter().write("ServletReqDistationDemo");
        response.getOutputStream().write("中国".getBytes("utf-8"));
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        this.doGet(request, response);
    }
}