package ru.job4j.servlets.crud.presentation.role;

import ru.job4j.servlets.crud.logic.role.ValidateRole;
import ru.job4j.servlets.crud.model.Role;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateRoleController extends HttpServlet {
    private static final String PATH_TO_UPDATE_JSP = "WEB-INF/views/role/update_role.jsp";
    private static final String ROLE_HOME_URI = "/role";
    private final ValidateRole logic = ValidateRole.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idRole = req.getParameter("id");
        String action = req.getParameter("action");
        if (idRole != null && action != null) {
            Role role = logic.findRoleById(Integer.parseInt(idRole));
            req.setAttribute("role", role);
            req.getRequestDispatcher(String.format("%s%s", req.getContextPath(), PATH_TO_UPDATE_JSP)).forward(req, resp);
        } else {
            resp.sendRedirect(String.format("%s%s", req.getContextPath(), ROLE_HOME_URI));
        }
    }
}















