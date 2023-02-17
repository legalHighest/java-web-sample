package top.hjh.request;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    private String message;
@Override
    public void init() {
        message = "Hello World!";
    System.out.println("初始化");
    }
@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String requestUrl=request.getRequestURI();
    System.out.println("url:"+requestUrl);
    request.getRequestDispatcher("/index.jsp").forward(request,response);//跳转页面request不会消失
//request.getAttribute(),获取数据
//    response.sendRedirect("/index.html");//request会消失，跳转页面
    response.setContentType("text/html");


        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }
@Override
    public void destroy() {
    }
}