package com.supinfo.supcrowdfunder.filter;

import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.entity.User;
import com.supinfo.supcrowdfunder.util.FlashBag;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Author: Gaël Demette
 * Date: 25/11/13
 * Time: 12:37
 */
public class AuthFilter implements Filter {
    public void destroy() {}

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        User currentUser = null;
        req.setAttribute("originURL", request.getRequestURL());
        if (email != null) {
            currentUser = UserDao.findUserByMail(email.toLowerCase());
        }
        if (currentUser != null) {
            req.setAttribute("currentUser", currentUser);
        } else {
            response.setStatus(401);
            ((FlashBag) req.getAttribute("flashbag")).addFlash("danger", "filter.auth.restrictedAccess");
            req.getRequestDispatcher("/login").forward(request, resp);
            return;
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {}

}
