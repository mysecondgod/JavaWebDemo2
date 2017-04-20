package top.mysecondgod.servlet.study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 线程安全
 * 
 * @author gacl
 * 
 * 
 */
public class ServletSecuDemo extends HttpServlet
{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        /**
         * 每一次请求会重新访问doGet方法，局部变量则不会产生线程问题，若定义全局变量，servlet只init一次，
         * 全局变量则会存在线程安全问题
         */
        int i = 0;
        i++;
        System.out.println(i);

    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        this.doGet(request, response);
    }
}