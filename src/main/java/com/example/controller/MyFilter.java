package com.example.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

@WebFilter(urlPatterns = "/hello-servlet")
public class MyFilter implements Filter {
    @Override public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }
    @Override public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request,new HttpServletResponseWrapper((HttpServletResponse)response){
            @Override
            public void setHeader(String name, String value) {
                if (!name.equals("demo"))
                super.setHeader(name, value);
            }
        });
    }
    @Override public void destroy() {
        Filter.super.destroy();
    }
}
