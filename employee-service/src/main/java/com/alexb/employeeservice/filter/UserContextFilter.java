package com.alexb.employeeservice.filter;

import com.alexb.employeeservice.utils.UserContext;
import com.alexb.employeeservice.utils.UserContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Slf4j
public class UserContextFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        UserContextHolder.getContext().setCorrelationId(httpServletRequest.getHeader(UserContext.CORRELATION_ID));

//        TODO:fix this later when security will be implemented
//        UserContextHolder.getContext().setAuthToken(httpServletRequest.getHeader(UserContext.AUTH_TOKEN));

        filterChain.doFilter(httpServletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}