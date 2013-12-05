package com.supinfo.supcrowdfunder.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;
import java.util.Locale;

/**
 * Author: Gaël Demette
 * Date: 05/12/13
 * Time: 01:15
 */
public class LocaleFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        String lang = request.getParameter("lang");
        if (lang != null && lang.length() > 0) {
            Locale language = new Locale(lang);
            Config.set(session, Config.FMT_LOCALE, language);
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
