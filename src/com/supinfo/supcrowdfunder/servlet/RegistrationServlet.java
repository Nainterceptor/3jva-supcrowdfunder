package com.supinfo.supcrowdfunder.servlet;

import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nainterceptor
 * Date: 20/11/13
 * Time: 14:37
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "RegistrationServlet", urlPatterns = {"/registration"})
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        List<User> users = UserDao.getAll();
        for (final User u: users) {
            out.println("Iterate");
        }
    }
}
