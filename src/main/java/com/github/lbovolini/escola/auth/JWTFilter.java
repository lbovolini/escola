package com.github.lbovolini.escola.auth;

import com.github.lbovolini.escola.service.AuthenticationService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JWTFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(JWTFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String token = req.getHeader(HttpHeaders.AUTHORIZATION);
        String role = req.getHeader("Role");

        if (token == null) {
            res.setStatus(401);
            return;
        }

        try {
            Jws<Claims> parser = AuthenticationService.decode(token, role);
            filterChain.doFilter(req, res);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            res.setStatus(401);
        }
    }

    @Override
    public void destroy() {

    }
}
