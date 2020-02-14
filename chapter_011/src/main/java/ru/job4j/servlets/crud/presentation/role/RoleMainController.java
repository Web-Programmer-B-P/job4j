package ru.job4j.servlets.crud.presentation.role;

import ru.job4j.servlets.crud.logic.role.ValidateRole;
import ru.job4j.servlets.crud.model.Role;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RoleMainController extends HttpServlet {
    private static final String LIST_ROLE_JSP = "WEB-INF/views/role/list_roles.jsp";
    private static final String WARNING_MESSAGE = "Операция не удалась";
    private final ValidateRole logic = ValidateRole.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Role> list = logic.findAllRoles();
        req.setAttribute("roles", list);
        req.getRequestDispatcher(String.format("%s%s", req.getContextPath(), LIST_ROLE_JSP)).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String idRole = req.getParameter("id");
        String roleName = req.getParameter("name");
        if (action.equals("update") && !idRole.isEmpty() && !roleName.isEmpty()) {
            logic.updateRole(new Role(Integer.parseInt(idRole), roleName));
        } else if (action.equals("create") && !roleName.isEmpty()) {
            logic.addRole(new Role(roleName));
        } else {
            req.setAttribute("warning", WARNING_MESSAGE);
        }
        doGet(req, resp);
    }
}
