package com.supinfo.supcrowdfunder.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

    public static final String ENCODING = "encoding"; //key for encoding.
    private String encoding;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter(ENCODING);
    }

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain filterChain)
            throws IOException, ServletException {
        req.setCharacterEncoding(encoding);
        resp.setContentType("text/html;charset=" + encoding);
        filterChain.doFilter(req, resp);
    }

    public void destroy() {
    }
}
