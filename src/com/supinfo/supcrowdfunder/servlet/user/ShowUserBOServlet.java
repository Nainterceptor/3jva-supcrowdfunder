package com.supinfo.supcrowdfunder.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: Gaël Demette
 * Date: 25/11/13
 * Time: 17:29
 */
@WebServlet(name = "ShowUserBOServlet", urlPatterns = {"/bo/user/show"})
public class ShowUserBOServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
