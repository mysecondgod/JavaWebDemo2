package top.mysecondgod.servlet.study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet 上下文参数获取web.xml参数
 * 
 * @author zhaijw
 * 
 * 
 */
public class ServletContextParamDemo extends HttpServlet
{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        /**
         * web.xml需要配置参数 <context-param> <param-name>url</param-name>
         * <param-value>http://mysecondgod.top</param-value> </context-param>
         */
        String url = this.getServletContext().getInitParameter("url");
        response.getWriter().write(url);
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        this.doGet(request, response);
    }
}