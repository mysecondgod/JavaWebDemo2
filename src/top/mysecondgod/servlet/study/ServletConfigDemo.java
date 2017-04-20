package top.mysecondgod.servlet.study;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet 参数配置
 * 
 * @author gacl
 * 
 * 
 */
public class ServletConfigDemo extends HttpServlet
{

    private ServletConfig servletConfig;


    @Override
    public void init(ServletConfig servletConfig) throws ServletException
    {
        System.out.println(servletConfig.toString());
        this.servletConfig = servletConfig;
        super.init();
    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String name = servletConfig.getInitParameter("name");
        System.out.println("name=" + name);
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        this.doGet(request, response);
    }
}