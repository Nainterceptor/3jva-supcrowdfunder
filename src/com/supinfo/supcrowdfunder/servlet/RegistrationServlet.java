package com.supinfo.supcrowdfunder.servlet;

import com.supinfo.supcrowdfunder.form.RegistrationType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

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
        if (form.getResult()) {
            form.persist(request);
        }
        PrintWriter out = response.getWriter();
        for (Map.Entry<String, String> e: form.getErrors().entrySet()) {
            out.println(e.getValue());
        }
        //this.getServletContext().getRequestDispatcher("/WEB-INF/registration_/form.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/registration_/form.jsp").forward(request, response);
    }
}
