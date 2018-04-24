package com.cs.servlet;

import com.cs.entity.Message;
import com.cs.entity.Ride;
import com.cs.entity.User;
import com.cs.service.RideService;
import com.cs.util.DateUtil;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author:Yanlong Wang
 * @Description:
 */
@WebServlet(urlPatterns = "/ride")
public class RideServlet extends HttpServlet {
    public static final String NOTSTART = "notstart";
    public static final String INPROCESSING = "inprocessing";
    public static final String END = "end";
    public static final String FLAG = "flag";
    private RideService rideService = new RideService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("add".equalsIgnoreCase(action)) {
            addRide(req, resp);
        } else if ("homepage".equalsIgnoreCase(action)) {
            List<Ride> notStartRideList = rideService.listRideByStatus(NOTSTART, "asc");
            List<Ride> onGoingRideList = rideService.listRideByStatus(INPROCESSING, "asc");
            List<Ride> flagRideList = rideService.listRideByStatus(FLAG, "asc");
            List<Message> msgList = rideService.listFlagUserAndMsg("asc");
            msgList = msgList.stream().filter(message -> Arrays.stream(message.getPaticipantids().split(",")).anyMatch(id -> id.equalsIgnoreCase((String) req.getSession().getAttribute(UserServlet.USERID)))).collect(Collectors.toList());
            req.setAttribute(NOTSTART, notStartRideList);
            req.setAttribute(INPROCESSING, onGoingRideList);
            req.setAttribute(FLAG, flagRideList);
            req.setAttribute("msglist", msgList);//flag message
            req.getRequestDispatcher(req.getContextPath() + "/homepage.jsp").forward(req, resp);
        } else if ("start".equalsIgnoreCase(action)) {
            String rideId = req.getParameter("id");
            rideService.updateStatus(rideId, INPROCESSING);
            resp.sendRedirect(req.getContextPath() + "/ride?action=homepage");
        } else if ("join".equalsIgnoreCase(action)) {
            String rideId = req.getParameter("id");
            rideService.addToRide((String) req.getSession().getAttribute(UserServlet.USERID), rideId);
            resp.sendRedirect(req.getContextPath() + "/ride?action=homepage");
        } else if ("listpaticipants".equalsIgnoreCase(action)) {
            String rideId = req.getParameter("id");
            List<User> userList = rideService.listPaticipant(rideId);
            req.setAttribute("userList", userList);
            req.getRequestDispatcher(req.getContextPath() + "/listpaticipants.jsp").forward(req, resp);
        } else if ("end".equalsIgnoreCase(action)) {
            String rideId = req.getParameter("id");
            rideService.updateStatus(rideId, END);
            resp.sendRedirect(req.getContextPath() + "/ride?action=homepage");
        } else if ("flag".equalsIgnoreCase(action)) {
            String rideId = req.getParameter("id");
            rideService.updateStatus(rideId, FLAG);
            resp.sendRedirect(req.getContextPath() + "/ride?action=homepage");
        } else if ("unflag".equalsIgnoreCase(action)) {
            String rideId = req.getParameter("id");
            rideService.updateStatus(rideId, INPROCESSING);
            resp.sendRedirect(req.getContextPath() + "/ride?action=homepage");
        } else if ("gorideinfo".equalsIgnoreCase(action)) {

            String rideId = req.getParameter("id");
            Ride ride = rideService.getRide(rideId);
            req.setAttribute("route", ride.getRoute());
            req.setAttribute("status", ride.getStatus());
            req.setAttribute("location", ride.getCurrentLocation());
            req.setAttribute("begindate", ride.getBegindate());
            req.getRequestDispatcher(req.getContextPath() + "/rideinfo.jsp").forward(req, resp);
        } else if ("create".equalsIgnoreCase(action)) {
            req.getRequestDispatcher(req.getContextPath() + "/ride.jsp").forward(req, resp);
        } else if ("message".equalsIgnoreCase(action)) {
            List<Message> msgList = rideService.listFlagUserAndMsg("asc");
            msgList = msgList.stream().filter(message -> Arrays.stream(message.getPaticipantids().split(",")).anyMatch(id -> id.equalsIgnoreCase((String) req.getSession().getAttribute(UserServlet.USERID)))).collect(Collectors.toList());

            Gson gson = new Gson();
            String json = gson.toJson(msgList);
            System.out.println(json);
            resp.getWriter().print(json);
            resp.flushBuffer();
        }

    }

    /**
     * @Author:Yanlong
     * @Date:4/23/2018_4:19 AM
     * @Description: save sign up
     */
    private void addRide(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String route = req.getParameter("route");
        String begindate = req.getParameter("begindate");
        Ride ride = new Ride();
        ride.setStatus(NOTSTART);
        ride.setCreatorUserId((String) req.getSession().getAttribute(UserServlet.USERID));
        ride.setBegindate(DateUtil.getDate(begindate, null));
        ride.setBanner("");
        ride.setRoute(route);
        ride.setId(null);
        ride.setCurrentLocation(null);
        rideService.addRide(ride);
        resp.sendRedirect(req.getContextPath() + "/ride?action=homepage");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}
