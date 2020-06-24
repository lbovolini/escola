package com.github.lbovolini.escola.auth;

import com.github.lbovolini.escola.service.AuthenticationService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;
import java.io.IOException;

public class JWTFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String token = req.getHeader(HttpHeaders.AUTHORIZATION);

        if (token == null) {
            res.setStatus(401);
            return;
        }

        try {
            Jws<Claims> parser = AuthenticationService.decode(token);
            filterChain.doFilter(req, res);
        } catch (Exception e) {
            res.setStatus(401);
        }
    }

    @Override
    public void destroy() {

    }
}
