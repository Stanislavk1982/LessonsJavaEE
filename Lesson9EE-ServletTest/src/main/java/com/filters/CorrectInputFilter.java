package com.filters;


import org.apache.commons.lang3.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

@WebFilter(urlPatterns = "/users/*")
public class CorrectInputFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        String password = req.getParameter("password_ui");
        String login = req.getParameter("login_ui");
        String age = req.getParameter("age_ui");
        String phone = req.getParameter("phone_ui");
        String email = req.getParameter("email_ui");
        String adres = req.getParameter("adres_ui");

        if (StringUtils.isNotEmpty(login) && StringUtils.isNotEmpty(password)
                && StringUtils.isNotEmpty(age) && StringUtils.isNotEmpty(phone)
                && StringUtils.isNotEmpty(email) && StringUtils.isNotEmpty(adres)) {

            chain.doFilter(req, resp);

        } else {

            errorMsg(resp, "Sorry, you didn't enter all parameters!!!");

        }
    }

    private void errorMsg(ServletResponse resp, String x) throws IOException {
        PrintWriter writer = resp.getWriter();

        writer.println(x);
        writer.flush();
    }


    public void destroy() {

    }
}
