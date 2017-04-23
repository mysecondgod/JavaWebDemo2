package top.mysecondgod.response.study;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 生成二维码图片
 */
public class ResponseImageDemo extends HttpServlet
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
        // response.setHeader("refresh", "5");
        // // 1.在内存中创建一张图片
        // BufferedImage image = new BufferedImage(100, 80,
        // BufferedImage.TYPE_INT_BGR);
        // Graphics2D g = (Graphics2D) image.getGraphics();
        // g.setBackground(Color.white);// 设置背景色
        // g.fillRect(0, 0, 80, 20);// 填充背景色
        // g.setColor(Color.red);// 设置字体颜色
        // g.drawString(makeNum(), 0, 20);
        //
        // // 设置浏览器打开类型
        // response.setContentType("image/jpeg");
        // // 设置不缓存
        // response.setDateHeader("expires", -1);
        // // 6.将图片写给浏览器
        // ImageIO.write(image, "jpg", response.getOutputStream());

        // response.sendRedirect("http://mysecondgod.top");

        // servletPath获取的是当前类的访问路径 /http/ResponseImageDemo （即上下文跟之后访问）
        String servletPath = request.getServletPath();
        response.getWriter().println(servletPath);
        // contextPath获取的是当前类的访问路径 /javawebdemo （即上下文根）
        String contextPath = request.getContextPath();
        response.getWriter().println(contextPath);
        // getRequestURL 获取的完整访问路径
        // http://localhost:8080/javawebdemo/http/ResponseImageDemo
        StringBuffer requestURL = request.getRequestURL();
        response.getWriter().println(requestURL);
        // getRequestURI 获取的是资源路径 /javawebdemo/http/ResponseImageDemo
        String requestURI = request.getRequestURI();
        response.getWriter().println(requestURI);

    }


    /**
     * 生成随机数字
     * 
     * @return
     */
    private String makeNum()
    {
        Random random = new Random();
        String num = random.nextInt(9999999) + "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 7 - num.length(); i++)
        {
            sb.append("0");
        }
        num = sb.toString() + num;
        return num;
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
