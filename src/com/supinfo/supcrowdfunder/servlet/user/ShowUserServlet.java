package com.supinfo.supcrowdfunder.servlet.user;

import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.entity.User;
import com.supinfo.supcrowdfunder.util.FlashBag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: Gaël Demette
 * Date: 27/11/13
 * Time: 18:30
 */
@WebServlet(name = "ShowUserServlet", urlPatterns = {"/user/show"})
public class ShowUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = request.getParameter("id") != null ? Long.parseLong(request.getParameter("id")) : null;
        User user = null;
        if (id != null && id > 0)
            user = UserDao.findOne(id);
        if (user == null) {
            ((FlashBag) request.getAttribute("flashbag")).addFlash("warning", "bo.page.user.notExist");
            response.sendRedirect("/");
        } else {
            request.setAttribute("user", user);
            this.getServletContext().getRequestDispatcher("/WEB-INF/user/show.jsp").forward(request, response);
        }
    }
}
