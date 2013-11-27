package com.supinfo.supcrowdfunder.servlet.user;

import com.supinfo.supcrowdfunder.entity.User;
import com.supinfo.supcrowdfunder.form.CreateUserType;
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
 * Time: 18:07
 */
@WebServlet(name = "CreateUserBOServlet", urlPatterns = {"/bo/user/create"})
public class CreateUserBOServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FlashBag flashbag = (FlashBag) request.getAttribute("flashbag");
        User user = new User();
        CreateUserType form = new CreateUserType();
        form.validate(request);
        user = form.fill(user, request);
        if (form.getResult()) {
            form.persist(user);
            flashbag.addFlash("success", "flash.bo.user.edit.success");
        } else {
            request.setAttribute("errors", form.getErrors() );
            request.setAttribute("result", form.getResult());
            flashbag.addFlash("danger", "flash.bo.user.edit.error");
        }
        request.setAttribute("user", user);
        this.getServletContext().getRequestDispatcher("/WEB-INF/bo/user/edit.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/bo/user/edit.jsp").forward(request, response);
    }
}
