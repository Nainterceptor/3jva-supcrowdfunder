package com.supinfo.supcrowdfunder.servlet.user;

import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.entity.User;
import com.supinfo.supcrowdfunder.form.UserType;
import com.supinfo.supcrowdfunder.util.FlashBag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: Gaël Demette
 * Date: 25/11/13
 * Time: 17:30
 */
@WebServlet(name = "EditUserBOServlet", urlPatterns = {"/bo/user/edit"})
public class EditUserBOServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = request.getParameter("id") != null ? Long.parseLong(request.getParameter("id")) : null;
        User user = null;
        FlashBag flashbag = (FlashBag) request.getAttribute("flashbag");
        if (id != null && id > 0)
            user = UserDao.findOne(id);
        if (user == null) {
            flashbag.addFlash("warning", "bo.page.user.notExist");
            response.sendRedirect("/bo/user");
        } else {
            UserType form = new UserType();
            form.validate(request);
            user = form.fill(user, request);
            if (form.getResult()) {

                form.persist(user);
                flashbag.addFlash("success", "bo.flash.user.edit.success");
            } else {
                request.setAttribute("errors", form.getErrors());
                request.setAttribute("result", form.getResult());
                flashbag.addFlash("danger", "bo.flash.user.edit.error");
            }
            request.setAttribute("user", user);
            this.getServletContext().getRequestDispatcher("/WEB-INF/bo/user/edit.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = request.getParameter("id") != null ? Long.parseLong(request.getParameter("id")) : null;
        User user = null;
        if (id != null && id > 0)
            user = UserDao.findOne(id);
        if (user == null) {
            ((FlashBag) request.getAttribute("flashbag")).addFlash("warning", "bo.page.user.notExist");
            response.sendRedirect("/bo/user");
        } else {
            request.setAttribute("user", user);
            this.getServletContext().getRequestDispatcher("/WEB-INF/bo/user/edit.jsp").forward(request, response);
        }
    }
}
