package ru.job4j.servlets.crud.presentation.user;

import ru.job4j.servlets.crud.logic.user.Validate;
import ru.job4j.servlets.crud.logic.role.ValidateRole;
import ru.job4j.servlets.crud.logic.user.ValidateUserService;
import ru.job4j.servlets.crud.model.Role;
import ru.job4j.servlets.crud.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserUpdateController extends HttpServlet {
    public static final String PATH_TO_UPDATE_JSP = "WEB-INF/views/user/update.jsp";
    public static final String LIST_URI = "/list";
    private final ValidateRole logicRole = ValidateRole.getInstance();
    private final Validate logicUser = ValidateUserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        String action = req.getParameter("action");
        List<Role> list = logicRole.findAllRoles();
        req.setAttribute("roles", list);
        if (idParam != null && action.equals("update")) {
            User editUser = logicUser.findById(Integer.parseInt(idParam));
            req.setAttribute("user", editUser);
            req.getRequestDispatcher(String.format("%s%s", req.getContextPath(), PATH_TO_UPDATE_JSP)).forward(req, resp);
        } else {
            req.getRequestDispatcher(String.format("%s%s", req.getContextPath(), LIST_URI)).forward(req, resp);
        }
    }
}
