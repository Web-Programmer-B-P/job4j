package ru.job4j.servlets.crud.presentation;

import ru.job4j.servlets.crud.logic.Validate;
import ru.job4j.servlets.crud.logic.ValidateService;
import ru.job4j.servlets.crud.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserUpdateController extends HttpServlet {
    private final Validate logic = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        String action = req.getParameter("action");
        if (idParam != null && action.equals("update")) {
            User editUser = logic.findById(Integer.parseInt(idParam));
            req.setAttribute("user", editUser);
            req.getRequestDispatcher(req.getContextPath() + "WEB-INF/views/update/update.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher(req.getContextPath() + "/list").forward(req, resp);
        }
    }
}
