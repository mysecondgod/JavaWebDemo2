package top.mysecondgod.servlet.study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 缓存servlet
 */
public class ServletBufferDemo extends HttpServlet
{
    private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBufferDemo()
    {
        super();
        // TODO Auto-generated constructor stub
    }


    /**
     * 在客户端缓存servlet的输出
     * 
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        String data = "testzzzz12343211234";
        response.setDateHeader("expires",
                System.currentTimeMillis() + 24 * 3600 * 1000);
        response.getOutputStream().write(data.getBytes());
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        // TODO Auto-generated method stub
    }

}
