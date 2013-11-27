package com.supinfo.supcrowdfunder.servlet.user;

import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Author: Gaël Demette
 * Date: 25/11/13
 * Time: 17:29
 */
@WebServlet(name = "ListUsersBOServlet", urlPatterns = {"/bo/user"})
public class ListUsersBOServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = UserDao.getAll();
        request.setAttribute("users", users);
        this.getServletContext().getRequestDispatcher("/WEB-INF/bo/user/list.jsp").forward(request, response);
    }
}
