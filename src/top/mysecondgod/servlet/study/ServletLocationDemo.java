package top.mysecondgod.servlet.study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http响应中的Location
 * 
 * @author gacl
 * 
 * 
 */
public class ServletLocationDemo extends HttpServlet
{

    /**
     * 2.步骤二，调用service方法创建 request\response
     * 
     * @author zhaijw
     * @see javax.servlet.http.HttpServlet#service(javax.servlet.ServletRequest,
     *      javax.servlet.ServletResponse)
     */
    @Override
    public void service(ServletRequest arg0, ServletResponse arg1)
            throws ServletException, IOException
    {
        // TODO Auto-generated method stub
        System.out.println("service-servlet");
        super.service(arg0, arg1);
        System.out.println("arg0" + arg0);
    }


    /**
     * 1.步骤一，调用Init方法
     * 
     * @author zhaijw
     * @see javax.servlet.GenericServlet#init()
     */
    @Override
    public void init() throws ServletException
    {
        System.out.println("init-servlet");
        super.init();
    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        response.setStatus(500);// 设置服务器的响应状态码
        /**
         * 设置响应头，服务器通过 Location这个头，来告诉浏览器跳到哪里，这就是所谓的请求重定向
         */
        response.setHeader("Location", "http://mysecondgod.top");
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        this.doGet(request, response);
    }
}