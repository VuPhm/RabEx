package com.rabex.express.security;

import com.rabex.express.core.dao.RID;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AuthorizeFilter extends HttpFilter {

    private List<AuthorizeMapping> authorizeMappings;
    private String permissionDeniedRedirectPath;
    private AuthorizeMapping anyRequestAuthorizeMappings;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        Authentication authentication = extractAuthentication((HttpServletRequest) req);
        String uri = getPath(req);
        Set<AuthorizeMapping> authorizeMappings = this.authorizeMappings.stream().filter(that -> that.matchedPattern(uri)).collect(Collectors.toSet());
        if(authorizeMappings.isEmpty()){

        }
    }

    private Authentication extractAuthentication(HttpServletRequest request) {
        Authentication authentication = (Authentication) request.getSession(true).getAttribute("AUTHENTICATION");
        if (authentication != null)
            return authentication;
        return new DefaultAuthentication(null);
    }

    private String getPath(ServletRequest request){
        return ((HttpServletRequest)request).getRequestURI();
    }


}
