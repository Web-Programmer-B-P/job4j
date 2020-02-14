package ru.job4j.servlets.crud.presentation.role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RoleCreateController extends HttpServlet {
    private static final String CREATE_ROLES_JSP = "WEB-INF/views/role/create_role.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(String.format("%s%s", req.getContextPath(), CREATE_ROLES_JSP)).forward(req, resp);
    }
}
