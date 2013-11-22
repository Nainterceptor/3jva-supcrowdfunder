package com.supinfo.supcrowdfunder.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Fireaxe
 * Date: 22/11/13
 * Time: 02:45
 * To change this template use File | Settings | File Templates.
 */

@WebServlet(name = "indexProjectServlet", urlPatterns = {"/Project"})
public class indexProjectServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/WEB-INF/project.jsp").forward(request, response);
    }
}
