package cn.shen.spring.service;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;

public class HelloServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //调用service


        ApplicationContext cac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        HelloService helloService = (HelloService) cac.getBean("helloService");
        helloService.say();
    }
}
