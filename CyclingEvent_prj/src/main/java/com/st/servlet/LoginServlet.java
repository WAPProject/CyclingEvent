package com.st.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Created by tao on 2017/4/2 0002.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String ctxPath = request.getContextPath();

            String indexPage = "/index.jsp";

            request.getSession().setAttribute("uId","1001");
            request.getSession().setAttribute("uName","1313");

            response.sendRedirect(ctxPath+indexPage);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
