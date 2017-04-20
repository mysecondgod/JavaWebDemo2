package top.mysecondgod.servlet.study;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http响应中的文件类型
 * 
 * @author gacl
 * 
 * 
 */
public class ServletContypeDemo extends HttpServlet
{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        response.setHeader("Context-type", "image/jpeg");
        InputStream in = this.getServletContext().getResourceAsStream(
                "/img/IMG_2691.JPG");

        // Byte buffer[] = new Byte[1024];
        // int len = 0;
        // OutputStream out = response.getOutputStream();// 得到输出流
        // while ((len = in.read()) > 0)
        // {// 读取输入流(in)里面的内容存储到缓冲区(buffer)
        // out.write(in.read());// 将缓冲区里面的内容输出到浏览器
        // }

        byte buffer[] = new byte[1024];
        int len = 0;
        OutputStream out = response.getOutputStream();// 得到输出流
        while ((len = in.read(buffer)) > 0)
        {// 读取输入流(in)里面的内容存储到缓冲区(buffer)
            out.write(buffer, 0, len);// 将缓冲区里面的内容输出到浏览器
        }
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        this.doGet(request, response);
    }
}