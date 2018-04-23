package com.cs.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CharsetFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        if (this.encode != null && !this.encode.equals("")) {
            request.setCharacterEncoding(this.encode);
            response.setContentType("text/html;charset=utf-8");
        } else {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
        }
        System.out.println("Charset Filter!");
        chain.doFilter(request, response);
    }

    private String encode = "UTF-8";

    public void init(FilterConfig config) throws ServletException {
        this.encode = config.getInitParameter("encoding");
        System.out.println(this.encode);
    }

}
