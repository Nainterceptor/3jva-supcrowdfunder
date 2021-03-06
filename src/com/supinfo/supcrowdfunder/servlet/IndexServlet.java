package com.supinfo.supcrowdfunder.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: Gaël Demette
 * Date: 19/11/13
 * Time: 17:34
 */
@WebServlet(name = "IndexServlet", urlPatterns = {""}, loadOnStartup = 1)
public class IndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/project").forward(request, response);
    }
}
