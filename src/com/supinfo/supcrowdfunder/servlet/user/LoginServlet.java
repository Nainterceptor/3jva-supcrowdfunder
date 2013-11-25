package com.supinfo.supcrowdfunder.servlet.user;

import com.supinfo.supcrowdfunder.form.LoginType;
import com.supinfo.supcrowdfunder.util.FlashBag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: Gaël Demette
 * Date: 23/11/13
 * Time: 21:48
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginType form = new LoginType();
        form.validate(request);
        FlashBag flashbag = (FlashBag) request.getAttribute("flashbag");
        if (form.getResult()) {
            flashbag.addFlash("success", "flash.login.success");
            request.getSession().setAttribute("email", request.getParameter("email"));
            response.sendRedirect("/");
        } else {
            request.setAttribute("errors", form.getErrors() );
            request.setAttribute("result", form.getResult());
            flashbag.addFlash("danger", "flash.login.error");
            this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
}
