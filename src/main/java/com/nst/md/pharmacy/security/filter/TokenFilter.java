package com.nst.md.pharmacy.security.filter;

import com.nst.md.pharmacy.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.access.AccessDeniedException;

@Component
public class TokenFilter extends OncePerRequestFilter {

   private static final String NST_HEADER_NAME = "NST-TOKEN";

   @Autowired
   private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (!"/login".equalsIgnoreCase(httpRequest.getRequestURI())) {
            String token = httpRequest.getHeader(NST_HEADER_NAME);
            if (StringUtils.hasText(token)) {
                try {
                    Authentication authentication = tokenService.parseUserFromToken(token);
                        SecurityContextHolder.getContext().setAuthentication(authentication);

                } catch (AccessDeniedException ade) {
                    AccessDeniedHandler acc = new AccessDeniedHandlerImpl();
                    acc.handle(request, response, ade);
                    return;
                }
            } else {
                SecurityContextHolder.getContext().setAuthentication(null);
            }
        }
        filterChain.doFilter(request,response);

    }
}
