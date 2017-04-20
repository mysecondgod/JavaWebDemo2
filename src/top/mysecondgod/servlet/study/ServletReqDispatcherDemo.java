package top.mysecondgod.servlet.study;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
public class ServletReqDispatcherDemo extends HttpServlet
{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String data = "<h1>testReqDis</h1>";
        response.getOutputStream().write(data.getBytes());
        // response.getWriter().write(data);

        ServletContext context = this.getServletContext();
        RequestDispatcher rd = context
                .getRequestDispatcher("/servlet/ServletReqDistationDemo");

        rd.forward(request, response);
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        this.doGet(request, response);
    }
}