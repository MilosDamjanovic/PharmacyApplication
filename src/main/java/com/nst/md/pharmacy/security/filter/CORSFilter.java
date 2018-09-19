package com.nst.md.pharmacy.security.filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CORSFilter implements Filter {
    @Override
    public void init(FilterConfig fc) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, NST-TOKEN, X-Requested-With, Origin,Access-Control-Request-Method, Access-Control-Request-Headers, Authorization");
        // httpServletResponse.setHeader("Access-Control-Allow-Headers","Content-Type, Accept, NST-TOKEN, responseType");
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "PUT, POST, GET, PATCH, OPTIONS, DELETE");
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        httpServletResponse.setHeader("Access-Control-Expose-Headers", "NST-TOKEN");

        if (!("OPTIONS").equalsIgnoreCase(httpServletRequest.getMethod())) {
            filterChain.doFilter(request, response);
        }
    }
    @Override
    public void destroy(){
    }
}
