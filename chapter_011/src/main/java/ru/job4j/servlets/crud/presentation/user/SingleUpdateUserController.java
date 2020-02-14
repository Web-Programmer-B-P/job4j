package ru.job4j.servlets.crud.presentation.user;

import ru.job4j.servlets.crud.logic.user.Validate;
import ru.job4j.servlets.crud.logic.user.ValidateUserService;
import ru.job4j.servlets.crud.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SingleUpdateUserController extends HttpServlet {
    private static final String UPDATE_USER_JSP = "/WEB-INF/views/user/single_user_update_page.jsp";
    private static final String USER_SINGLE_PAGE_JSP = "WEB-INF/views/user/single_user_page.jsp";
    private final Validate logic = ValidateUserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam != null) {
            req.setAttribute("user", logic.findById(Integer.parseInt(idParam)));
            req.getRequestDispatcher(String.format("%s%s", req.getContextPath(), UPDATE_USER_JSP)).forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String idParam = req.getParameter("id");
        if (action.equals("update") && idParam != null) {
            User user = logic.findById(Integer.parseInt(idParam));
            logic.update(fill(user, req));
            req.setAttribute("user", user);
        }
        if (action.equals("image_update") && idParam != null) {
            User user = logic.findById(Integer.parseInt(idParam));
            logic.update(fill(user, req));
            req.setAttribute("user", user);
        }
        req.getRequestDispatcher(String.format("%s%s", req.getContextPath(), USER_SINGLE_PAGE_JSP)).forward(req, resp);
    }

    private User fill(User user, HttpServletRequest req) {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String image = req.getParameter("image");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        if (name != null) {
            user.setName(name);
        }
        if (login != null) {
            user.setLogin(login);
        }
        if (email != null) {
            user.setEmail(email);
        }
        if (image != null) {
            user.setPhotoId(image);
        }
        if (password != null) {
            user.setPassword(password);
        }
        if (role != null) {
            user.setRoleId(Integer.parseInt(role));
        }
        user.setCreateDate(System.currentTimeMillis());
        return user;
    }
}
