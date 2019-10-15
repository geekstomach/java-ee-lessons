package com.geekstomach.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter(filterName = "charset", urlPatterns = "/*")
public class CharsetFilter implements Filter {
private transient FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
servletResponse.setContentType("text/html; charset=UTF-8");
servletResponse.setCharacterEncoding("UTF-8");
filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
