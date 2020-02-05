package ru.job4j.servlets.crud.presentation;

import ru.job4j.servlets.crud.logic.Validate;
import ru.job4j.servlets.crud.logic.ValidateService;
import ru.job4j.servlets.crud.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserMainController extends HttpServlet {
    private final Validate logic = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<User> list = logic.findAll();
        req.setAttribute("userList", list);
        req.getRequestDispatcher("WEB-INF/views/index/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = req.getParameter("action");
        String idParam = req.getParameter("id");
        int id = 0;
        if (action.equals("add")) {
            User user = new User();
            logic.add(fill(user, req));
            resp.sendRedirect(req.getContextPath() + "/list");
        }

        if (action.equals("update")) {
            if (idParam != null) {
                id = Integer.parseInt(req.getParameter("id"));
                User userUpdate = logic.findById(id);
                logic.update(fill(userUpdate, req));
                resp.sendRedirect(req.getContextPath() + "/list");
            }
        }

        if (action.equals("delete")) {
            if (idParam != null) {
                id = Integer.parseInt(req.getParameter("id"));
                logic.delete(id);
                resp.sendRedirect(req.getContextPath() + "/list");
            }
        }
    }

    private User fill(User user, HttpServletRequest req) {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        if (name != null) {
            user.setName(name);
        }
        if (login != null) {
            user.setLogin(login);
        }
        if (email != null) {
            user.setEmail(email);
        }
        user.setCreateDate(System.currentTimeMillis());
        return user;
    }
}
