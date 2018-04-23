package com.cs.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by tao on 2017/4/6 0006.
 */
@WebFilter(filterName="LoginFilter",urlPatterns="/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        String currentURL = request.getRequestURI();
        System.out.println("currentURL:"+currentURL);
        String ctxPath = request.getContextPath();
        System.out.println("ctxPath:"+ctxPath);
        //除掉项目名称时访问页面当前路径
        String targetURL = currentURL.substring(ctxPath.length());
        System.out.println("targetURL:"+targetURL);
        //登录页面
        String loginPage = "/login.jsp";
        //注册页面
        String registerPage = "/register.jsp";
        //登录的Servlet对应的url
        String loginServlet = "/user?action=login";
        HttpSession session = request.getSession(false);
        //对当前页面进行判断，如果当前页面不为登录页面
        if(loginPage.equals(targetURL)){
            //这里表示如果当前页面是登陆页面，跳转到登陆页面
            chain.doFilter(request, response);

        }else if(registerPage.equals(targetURL)){
            //这里表示如果当前页面是注册页面，跳转到注册页面
            chain.doFilter(request, response);
        }else if(targetURL.endsWith(".txt")||
                targetURL.endsWith(".js")||
                targetURL.endsWith(".css")||
                targetURL.endsWith(".png")||
                targetURL.endsWith(".jpg")||
                targetURL.endsWith(".bmp")
                ){
            //这里表示如果是静态资源，可以访问
            chain.doFilter(request, response);
        } else{
            if(loginServlet.equals(targetURL)){
                //Servlet验证
                chain.doFilter(request, response);

            }else{
                //在不为登陆页面时，再进行判断，如果不是登陆页面也没有session则跳转到登录页面，
                if(session == null || session.getAttribute(UserServlet.USERSESSION) == null ){
                    response.sendRedirect(ctxPath+loginPage);
                    System.out.println("redirect:"+ctxPath+loginPage);

                }else{
                    //这里表示正确，会去寻找下一个链，如果不存在，则进行正常的页面跳转
                    chain.doFilter(request, response);

                }
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
