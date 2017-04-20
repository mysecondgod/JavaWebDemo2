package top.mysecondgod.response.study;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 下载文件
 */
public class ResponseDownloadDemo extends HttpServlet
{
    private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        // 1.读取文件
        String realPath = this.getServletContext().getRealPath("/img/风景.jpg");
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        // response.setHeader("content-disposition", "attachment;filename="
        // + URLDecoder.decode(fileName, "UTF-8"));

        // 2.关键点
        response.setHeader("content-disposition", "attachment;filename="
                + URLEncoder.encode(fileName, "UTF-8"));

        // InputStream is = new FileInputStream(url);
        InputStream in = new FileInputStream(realPath);

        int len = 0;
        byte[] buffer = new byte[1024];
        // 3.while的用法，循环读取。在编写下载文件功能时，要使用OutputStream流，避免使用PrintWriter流，因为OutputStream流是字节流，可以处理任意类型的数据，而PrintWriter流是字符流，只能处理字符数据，如果用字符流处理字节数据，会导致数据丢失。
        while ((len = in.read(buffer)) > 0)
        {
            response.getOutputStream().write(buffer, 0, len);
        }
        in.close();

        // //1.获取要下载的文件的绝对路径
        // String realPath =
        // this.getServletContext().getRealPath("/img/风景.jpg");
        // //2.获取要下载的文件名
        // String fileName = realPath.substring(realPath.lastIndexOf("\\")+1);
        // //3.设置content-disposition响应头控制浏览器以下载的形式打开文件
        // response.setHeader("content-disposition",
        // "attachment;filename="+fileName);
        // //4.获取要下载的文件输入流
        // InputStream in = new FileInputStream(realPath);
        // int len = 0;
        // //5.创建数据缓冲区
        // byte[] buffer = new byte[1024];
        // //6.通过response对象获取OutputStream流
        // OutputStream out = response.getOutputStream();
        // //7.将FileInputStream流写入到buffer缓冲区
        // while ((len = in.read(buffer)) > 0) {
        // //8.使用OutputStream将缓冲区的数据输出到客户端浏览器
        // out.write(buffer,0,len);
        // }
        // in.close();
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
