package top.mysecondgod.servlet.study;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet 上下文传递参数
 * 
 * @author zhaijw
 * 
 * 
 */
public class ServletContext2Demo extends HttpServlet
{
    /**
     * (non-Javadoc)
     * 
     * @author zhaijw
     * @see javax.servlet.GenericServlet#init()
     */
    @Override
    public void init() throws ServletException
    {
        System.out.println("ServletContext2Demo.init");
        super.init();
    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.getSession();
        ServletContext context = this.getServletContext();
        response.getWriter().write(context.getAttribute("data").toString());
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        this.doGet(request, response);
    }
}