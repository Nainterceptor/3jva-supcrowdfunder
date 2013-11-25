package com.supinfo.supcrowdfunder.filter;

import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Author: Gaël Demette
 * Date: 25/11/13
 * Time: 12:37
 */
@WebFilter(urlPatterns = {"/bo/*", "/me/*"})
public class AuthFilter implements Filter {
    public void destroy() {}

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();

        String email = ((String) session.getAttribute("email")).toLowerCase();
        User currentUser = UserDao.findUserByMail(email);

        if (currentUser != null) {
            request.setAttribute("currentUser", currentUser);
        } else {
            response.setStatus(401);
            request.getRequestDispatcher("/login").forward(request, resp);
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {}

}
