package com.supinfo.supcrowdfunder.servlet.user;

import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.form.RegistrationType;
import com.supinfo.supcrowdfunder.util.FlashBag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: Gaël Demette
 * Date: 20/11/13
 * Time: 14:37
 */
@WebServlet(name = "RegistrationServlet", urlPatterns = {"/registration"})
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RegistrationType form = new RegistrationType();
        form.validate(request);
        FlashBag flashbag = (FlashBag) request.getAttribute("flashbag");
        if (form.getResult()) {
            Boolean becomeAdmin = !UserDao.hasUser();
            if (becomeAdmin)
                flashbag.addFlash("info", "flash.registration.info");
            form.persist(request, becomeAdmin);
            flashbag.addFlash("success", "flash.registration.success");
            //Log et redirect
            request.getSession().setAttribute("email", request.getParameter("email").toLowerCase());
            response.sendRedirect(request.getContextPath()+"/");
        } else {
            request.setAttribute("errors", form.getErrors());
            request.setAttribute("result", form.getResult());
            flashbag.addFlash("danger", "flash.registration.error");
            this.getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp").forward(request, response);
    }
}
