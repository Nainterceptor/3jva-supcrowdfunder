package com.supinfo.supcrowdfunder.servlet.user;

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
 * Time: 15:13
 */
@WebServlet(name = "LogoutServlet", urlPatterns = {"/me/logout"})
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("email");
        ((FlashBag) request.getAttribute("flashbag")).addFlash("success", "flash.logout.success");
        response.sendRedirect("/");
    }
}
