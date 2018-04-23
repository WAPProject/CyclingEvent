package com.cs.servlet;

import com.cs.entity.User;
import com.cs.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:Yanlong Wang
 * @Description:
 */
@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    public static final String USERSESSION = "currentusersession";
    public static final String USERID = "currentuserid";
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("add".equalsIgnoreCase(action)) {
            addUser(req, resp);
        }else if("login".equalsIgnoreCase(action)) {
            login(req, resp);
        }else if("logout".equalsIgnoreCase(action)){
            req.getSession().invalidate();
            resp.sendRedirect(req.getContextPath() + "login.jsp");
        }else if("goregister".equalsIgnoreCase(action)){
            resp.sendRedirect(req.getContextPath() + "/register.jsp");
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User dbUser = userService.checkLogin(user);
        if(dbUser != null){
            req.getSession().setAttribute(USERSESSION,dbUser);
            req.getSession().setAttribute(USERID,dbUser.getId());
            resp.sendRedirect(req.getContextPath() + "/ride?action=homepage");
        }else{
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }

    /**
    *@Author:Yanlong
    *@Date:4/23/2018_4:19 AM
    *@Description: save sign up
    */
    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        user.setId(null);
        System.out.println("username:"+user.getUsername()+",emailaddress:"+user.getEmail());
        userService.addUser(user);
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
