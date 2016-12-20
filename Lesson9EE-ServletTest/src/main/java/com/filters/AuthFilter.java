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

@WebFilter(urlPatterns = "/usersAsync1/*")
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String password = req.getParameter("password_ui");
        String login = req.getParameter("login_ui");
        if (!StringUtils.isEmpty(login) && StringUtils.isNotEmpty(password)) {
//            InputStream resourceAsStream = AuthFilter.class.getClassLoader()
//                    .getResourceAsStream("users.properties");

            InputStream resourceAsStream = AuthFilter.class.getResourceAsStream("users.properties");


            Properties properties = new Properties();
            properties.load(resourceAsStream);
            String adminlogin = properties.getProperty("login");
            String adminpassword = properties.getProperty("password");
            if (adminlogin.equals(login) && adminpassword.equals(password)) {
                chain.doFilter(req, resp);
            } else {

                errorMsg (resp, "Sorry, you aren't admin!!!");

            }

        } else {
            errorMsg (resp, "ERROR!!!");
        }
    }
    private void errorMsg(ServletResponse resp, String x) throws IOException {
        PrintWriter writer = resp.getWriter();

        writer.println(x);
        writer.flush();
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
