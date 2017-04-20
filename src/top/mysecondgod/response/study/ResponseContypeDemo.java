package top.mysecondgod.response.study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 响应的字符转换
 */
public class ResponseContypeDemo extends HttpServlet
{
    private static final long serialVersionUID = 1L;


    /**
     * 中文转换问题<br>
     * 在服务端设置的编码格式在客户端需要设置对应的编码格式才不会乱码。如当前服务端的默认编码方式为uft-8，当未指定getBytes()编码格式时，
     * 浏览器 会读取当前系统的编码方式，IE会默认获取GB2312码表进行编码。此时需要通过response向服务端指定编码方式
     * 
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        // 1.使用outputstream的方式输出中文
        String china = "中国";
        // response.setHeader("context-type", "text/html;charset=UTF-8");
        // response.setHeader("content-type", "text/html;charset=UTF-8");
        // response.getOutputStream().write(china.getBytes("UTF-8"));

        String data = "中国";

        // 通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        // response.setHeader("content-type", "text/html;charset=UTF-8");

        response.setCharacterEncoding("UTF-8");// 设置将字符以"UTF-8"编码输出到客户端浏览器
        /**
         * PrintWriter out =
         * response.getWriter();这句代码必须放在response.setCharacterEncoding
         * ("UTF-8");之后
         * 否则response.setCharacterEncoding("UTF-8")这行代码的设置将无效，浏览器显示的时候还是乱码
         */
        PrintWriter out = response.getWriter();// 获取PrintWriter输出流
        /**
         * 多学一招：使用HTML语言里面的<meta>标签来控制浏览器行为，模拟通过设置响应头控制浏览器行为 out.write(
         * "<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>"
         * ); 等同于response.setHeader("content-type", "text/html;charset=UTF-8");
         */
        out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
        out.write(data);// 使用PrintWriter流向客户端输出字符

        out.write(1 + "");
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
