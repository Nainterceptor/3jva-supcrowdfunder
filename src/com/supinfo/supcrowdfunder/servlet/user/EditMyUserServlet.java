package com.supinfo.supcrowdfunder.servlet.user;

import com.supinfo.supcrowdfunder.entity.User;
import com.supinfo.supcrowdfunder.form.EditMyUserType;
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
 * Time: 18:40
 */
@WebServlet(name = "EditMyUserServlet", urlPatterns = {"/me/edit"})
public class EditMyUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getAttribute("currentUser");
        FlashBag flashbag = (FlashBag) request.getAttribute("flashbag");
        EditMyUserType form = new EditMyUserType();
        form.validate(request);
        user = form.fill(user, request);
        if (form.getResult()) {
            form.persist(user);
            flashbag.addFlash("success", "bo.flash.user.edit.success");
        } else {
            request.setAttribute("errors", form.getErrors() );
            request.setAttribute("result", form.getResult());
            flashbag.addFlash("danger", "bo.flash.user.edit.error");
        }
        request.setAttribute("user", user);
        this.getServletContext().getRequestDispatcher("/WEB-INF/user/edit.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getAttribute("currentUser");
        request.setAttribute("user", user);
        this.getServletContext().getRequestDispatcher("/WEB-INF/user/edit.jsp").forward(request, response);
    }
}
