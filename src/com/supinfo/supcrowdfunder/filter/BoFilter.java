package com.supinfo.supcrowdfunder.filter;

import com.supinfo.supcrowdfunder.entity.User;
import com.supinfo.supcrowdfunder.util.FlashBag;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: Gaël Demette
 * Date: 26/11/13
 * Time: 11:10
 */
public class BoFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        User currentUser = (User) req.getAttribute("currentUser");
        if (currentUser == null || currentUser.getAdmin() == null || currentUser.getAdmin().equals(false)) {
            response.setStatus(401);
            ((FlashBag) req.getAttribute("flashbag")).addFlash("danger", "filter.bo.restrictedAccess");
            req.getRequestDispatcher("/login").forward(request, resp);
            return;
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
