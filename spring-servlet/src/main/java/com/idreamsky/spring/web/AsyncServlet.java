package com.idreamsky.spring.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 异步Servlet
 *
 * @Author: colby
 * @Date: 2019/2/13 20:27
 */
@WebServlet(
        asyncSupported = true, // 激活异步特性
        name = "asyncServlet",
        urlPatterns = "/async-servlet"
)
public class AsyncServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 判断是否支持异步
        if (req.isAsyncSupported()) {
            AsyncContext asyncContext = req.startAsync();

            asyncContext.setTimeout(50L);
            asyncContext.addListener(new AsyncListener() {
                @Override
                public void onComplete(AsyncEvent event) throws IOException {
                    print("执行完成", 0);
                }

                @Override
                public void onTimeout(AsyncEvent event) throws IOException {
                    HttpServletResponse response = (HttpServletResponse)event.getSuppliedResponse();
                    response.setStatus(503);
                    print("执行超时", 0);
                }

                @Override
                public void onError(AsyncEvent event) throws IOException {
                    print("执行错误", 0);
                }

                @Override
                public void onStartAsync(AsyncEvent event) throws IOException {
                    print("开始执行", 0);
                }
            });
            print("Hello,World", 0);
//            ServletResponse response = asyncContext.getResponse();
//            response.setContentType("text/plain;charset=UTF-8");
//            PrintWriter writer = response.getWriter();
//            writer.write("Hello,World");
//            writer.flush();
        }
    }

    private void print(Object obj, Integer sleep) {
        try {
            Thread.sleep(sleep);
            String threadName = Thread.currentThread().getName();
            System.out.println("AsyncServlet[" + threadName + "]" + obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
