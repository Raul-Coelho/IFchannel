package com.ifpb.controller.filter;

import com.ifpb.model.entidades.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "authenticationFilter", urlPatterns = {"/home.jsp"})
public class AuthenticationFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)servletRequest).getSession();

        User user = (User) session.getAttribute("user");

        if(user == null){
            ((HttpServletResponse) servletResponse).sendRedirect("index.html");
        }else if(user.getPrivilege() == "professor"){
            ((HttpServletResponse) servletResponse).sendRedirect("professorPage.jsp?success=1");
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            ((HttpServletResponse) servletResponse).sendRedirect("studentPage.jsp?success=1");
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}