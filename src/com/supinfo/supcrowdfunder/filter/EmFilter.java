package com.supinfo.supcrowdfunder.filter;

import com.supinfo.supcrowdfunder.dao.DaoRessource;

import javax.servlet.*;
import java.io.IOException;

/**
 * Author: Gaël Demette
 * Date: 03/12/13
 * Time: 22:27
 */
public class EmFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        DaoRessource.init();
        chain.doFilter(req, resp);
        DaoRessource.destroy();
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
