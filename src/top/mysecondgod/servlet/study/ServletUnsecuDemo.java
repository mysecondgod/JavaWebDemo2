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
public class ServletUnsecuDemo extends HttpServlet
{

    int i = 0;


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        /**
         * 加入synchronized会解决线程安全问题，因为每一次请求都会获取一把锁，另一次请求得等上一次请求把锁归还才能再次获取，
         * 即将并发变成单线程来解决问题
         * 
         */

        // synchronized (this)
        // {
        // i++;
        // try
        // {
        // Thread.sleep(1000 * 4);
        // }
        // catch (InterruptedException e)
        // {
        // e.printStackTrace();
        // }
        // response.getWriter().write(i + "");
        //
        // }

        i++;
        try
        {
            Thread.sleep(1000 * 4);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        response.getWriter().write(i + "");

    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        this.doGet(request, response);
    }
}