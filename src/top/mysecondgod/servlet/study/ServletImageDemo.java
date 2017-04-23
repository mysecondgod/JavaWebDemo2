package top.mysecondgod.servlet.study;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet 绘制图片验证码
 */
public class ServletImageDemo extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    private final int width = 120;
    private final int height = 30;


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request, response);
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        // 1.内存中创建image
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        // 2.得到一个画板
        Graphics g = image.getGraphics();

        // 3.设置画板属性-背景色
        setBackground(g);

        // 4.设置图片边框
        setBorder(g);

        // 5.设置干扰线
        drawRandowLine(g);

        // 6.绘制随机数
        String random = drawRandowNum((Graphics2D) g, "l");

        // 7.保存随机数至session
        request.getSession().setAttribute("checkCode", random);

        // 8.设置浏览器以图片形式打开
        response.setHeader("ContentType", "image/jpeg");

        // 9.设置不缓存
        response.setHeader("Cache-Control", "no-cache");

        // 10.将图片写至浏览器
        ImageIO.write(image, "jpg", response.getOutputStream());
    }


    /**
     * 
     * 设置图片背景色
     * 
     * @author Zhaijw
     * @param %param name% %param description%
     * @return
     */
    private void setBackground(Graphics g)
    {
        // 设置颜色
        g.setColor(Color.white);
        // 设置颜色区域
        g.fillRect(0, 0, width, height);
    }


    private void setBorder(Graphics g)
    {
        g.setColor(Color.blue);
        g.fillRect(1, 1, width - 1, height - 1); // 此处-1 与-2 有何不同
    }


    private void drawRandowLine(Graphics g)
    {
        g.setColor(Color.green);
        for (int i = 0; i < 5; i++)
        {
            int x1 = new Random().nextInt(width);
            int x2 = new Random().nextInt(width);
            int y1 = new Random().nextInt(height);
            int y2 = new Random().nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }
    }


    private String drawRandowNum(Graphics2D g, String... createTypeFlag)
    {
        g.setColor(Color.red);
        g.setFont(new Font("宋体", Font.BOLD, 20));// 设置字体类型，是否加粗，字体大小
        // 基础中文
        String baseChineseType = "\u7684\u4e00\u4e86\u662f\u6211\u4e0d\u5728\u4eba\u4eec\u6709\u6765\u4ed6\u8fd9\u4e0a\u7740\u4e2a\u5730\u5230\u5927\u91cc\u8bf4";
        // 数字和字母的组合
        String baseNumLetter = "0123456789ABCDEFGHJKLMNOPQRSTUVWXYZ";
        // 数字
        String baseNum = "0123456789";
        // 纯字母
        String baseLetter = "ABCDEFGHJKLMNOPQRSTUVWXYZ";
        if (createTypeFlag.length > 0 && null != createTypeFlag[0])
        {
            if (createTypeFlag[0].equals("n"))
            {
                createRandomChar(g, baseNum);
            }
            else if (createTypeFlag[0].equals("l"))
            {
                createRandomChar(g, baseLetter);
            }
        }

        return "";
    }


    private String createRandomChar(Graphics2D g, String baseChar)
    {
        StringBuffer sb = new StringBuffer();
        String ch = "";
        for (int i = 0; i < 4; i++)
        {
            ch = baseChar.charAt(new Random().nextInt(baseChar.length())) + "";
            sb.append(ch);
        }

        g.drawString(sb.toString(), 0, 20);

        return sb.toString();

    }
}
