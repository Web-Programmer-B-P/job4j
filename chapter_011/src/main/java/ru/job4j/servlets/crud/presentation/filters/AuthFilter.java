package ru.job4j.servlets.crud.presentation.filters;

import ru.job4j.servlets.crud.model.User;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
    private static final String SING_IN_URI = "/sing-in";

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (!req.getRequestURI().contains(SING_IN_URI)) {
            HttpSession session = req.getSession();
            if (session.isNew() || session.getAttribute("user") == null) {
                resp.sendRedirect(String.format("%s%s", req.getContextPath(), SING_IN_URI));
                return;
            }
            User user = (User) session.getAttribute("user");
            String role = user.getRoleName();
            if (role.equals("admin")) {
                chain.doFilter(req, resp);
                return;
            } else if (role.equals("user") && req.getRequestURI().contains("_user")
                    || req.getRequestURI().contains("/download")) {
                chain.doFilter(req, resp);
                return;
            } else {
                resp.sendRedirect(String.format("%s%s", req.getContextPath(), SING_IN_URI));
                return;
            }
        }
        chain.doFilter(req, resp);
    }
}
