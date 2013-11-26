package com.supinfo.supcrowdfunder.filter;

import com.supinfo.supcrowdfunder.util.FlashBag;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Author: Gaël Demette
 * Date: 25/11/13
 * Time: 00:51
 */
public class FlashFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        FlashBag flashbag = new FlashBag(session);
        req.setAttribute("flashbag", flashbag);
        chain.doFilter(req, resp);
        flashbag.persist(request);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
