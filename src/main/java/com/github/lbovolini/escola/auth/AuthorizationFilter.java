package com.github.lbovolini.escola.auth;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthorizationFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(AuthorizationFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String role = req.getHeader("Role");

        try {
            boolean hasPermission = Permissions.isAuthorized(req.getRequestURI(), req.getMethod(), role);

            if (!hasPermission) {
                res.setStatus(403);
                return;
            }
            filterChain.doFilter(req, res);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            res.setStatus(403);
        }
    }

    @Override
    public void destroy() {

    }
}
