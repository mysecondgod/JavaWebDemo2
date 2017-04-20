package top.mysecondgod.servlet.study;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http响应中的压缩
 * 
 * @author gacl
 * 
 * 
 */
public class ServletGzipDemo extends HttpServlet
{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        String a = "zzzzzzzzzzzzxxxxxxxxxxxxxxxccccccccccccccvvvvvvvvvvvvvvvvvbbbbbbbbbbbbbbnnnnnnnnnn";
        System.out.println(">>>>>>>>>>>>" + a.getBytes().length);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        GZIPOutputStream gops = new GZIPOutputStream(baos);
        gops.write(a.getBytes());
        gops.close();

        // response.setContentLength(baos.toByteArray().length);
        // response.getOutputStream().write(a.getBytes());

        // 得到压缩后的数据
        byte g[] = baos.toByteArray();
        response.setHeader("Content-Encoding", "gzip");
        response.setHeader("Content-Length", g.length + "");
        response.getOutputStream().write(g);
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        this.doGet(request, response);
    }
}