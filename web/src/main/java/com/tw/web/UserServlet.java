package com.tw.web;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

import com.tw.core.util.Constance;
import com.tw.core.entity.User;
import com.tw.core.dao.UserDao;

public class UserServlet extends HttpServlet {

    private UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        request.setAttribute("users", new UserDao().getUsers());

        if (Constance.UPDATE_ACTION.equals(action)) {

            int userId = Integer.parseInt(request.getParameter("userId"));
            User user = userDao.getUserById(userId);

            RequestDispatcher view = request.getRequestDispatcher("/user.jsp");
            request.setAttribute("user", user);
            view.forward(request, response);

        } else if(Constance.DELETE_ACTION.equals(action)) {

            int userId = Integer.parseInt(request.getParameter("userId"));
            userDao.deleteUser(userId);
            request.setAttribute("users", userDao.getUsers());
            RequestDispatcher view = request.getRequestDispatcher("/users.jsp");
            view.forward(request, response);

        } else {

            RequestDispatcher view = request.getRequestDispatcher("/users.jsp");
            view.forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();

        user.setName(request.getParameter("name"));
        user.setGender(request.getParameter("gender"));
        user.setEmail(request.getParameter("email"));
        user.setAge(Integer.parseInt(request.getParameter("age")));

        String userId = request.getParameter("userId");

        if (userId == null || userId.isEmpty()) {
            userDao.addUser(user);
        } else {
            user.setId(Integer.parseInt(userId));
            userDao.updateUser(user);
        }

        RequestDispatcher view = request.getRequestDispatcher("/users.jsp");
        request.setAttribute("users", userDao.getUsers());
        view.forward(request, response);
    }
}