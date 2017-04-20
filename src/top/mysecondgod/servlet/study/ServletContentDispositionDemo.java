package top.mysecondgod.servlet.study;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http响应中的下载文件
 * 
 * @author gacl
 * 
 * 
 */
public class ServletContentDispositionDemo extends HttpServlet
{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setHeader("content-disposition", "attachment;filename=xxx.jpg");
        InputStream in = this.getServletContext().getResourceAsStream(
                "/img/IMG_2691.JPG");

        OutputStream opt = response.getOutputStream();

        byte buffer[] = new byte[1024];
        int a = 0;
        while ((a = in.read(buffer)) > 0)
        {
            opt.write(buffer, 0, a);
        }

    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        this.doGet(request, response);
    }
}