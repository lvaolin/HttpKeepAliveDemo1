package com.dahuangya.httpkeepalive.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

//@WebServlet(name = "servlet1",urlPatterns = "/servlet1" )
public class Servlet1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("hello");

        resp.setContentType("application/json");

        PrintWriter out = resp.getWriter();
        int nextConfig = 1;
        while (true){
            try {
                TimeUnit.SECONDS.sleep(3);
                Random ra =new Random();
                int temp = ra.nextInt(30);
                if(temp!=nextConfig){
                    nextConfig = temp;
                    System.out.println("参数发生了变化，通知客户端。config："+nextConfig);
                    out.println(nextConfig);
                    out.flush();
                    out.close();
                    break;
                }else{
                    System.out.println("参数没有变化。继续检测服务器端参数的状态。。。");
                }

            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         doPost(req,resp);

    }


}
