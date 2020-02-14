package ru.job4j.servlets.crud.presentation.user;

import ru.job4j.servlets.crud.logic.user.Validate;
import ru.job4j.servlets.crud.logic.user.ValidateUserService;
import ru.job4j.servlets.crud.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserMainController extends HttpServlet {
    private static final String LIST_URI = "/list";
    private static final String PATH_TO_LIST_JSP = "WEB-INF/views/user/list.jsp";
    private static final String ID_PARAMETER = "id";
    private final Validate logic = ValidateUserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<User> list = logic.findAll();
        req.setAttribute("userList", list);
        req.getRequestDispatcher(String.format("%s%s", req.getContextPath(), PATH_TO_LIST_JSP)).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter("action");
        String idParam = req.getParameter(ID_PARAMETER);
        int id = 0;
        if (action.equals("add")) {
            User user = new User();
            logic.add(fill(user, req));
            resp.sendRedirect(String.format("%s%s", req.getContextPath(), LIST_URI));
        }

        if (action.equals("update")) {
            if (idParam != null) {
                id = Integer.parseInt(req.getParameter(ID_PARAMETER));
                User userUpdate = logic.findById(id);
                logic.update(fill(userUpdate, req));
                resp.sendRedirect(String.format("%s%s", req.getContextPath(), LIST_URI));
            }
        }

        if (action.equals("delete")) {
            deleteImageBeforeDeleteUser(req);
            if (idParam != null) {
                id = Integer.parseInt(req.getParameter(ID_PARAMETER));
                logic.delete(id);
                resp.sendRedirect(String.format("%s%s", req.getContextPath(), LIST_URI));
            }
        }
    }

    private void deleteImageBeforeDeleteUser(HttpServletRequest req) {
        File fileToTrash = new File(UserCreateController.PATH_TO_SAVE_IMAGES + req.getParameter("image"));
        if (fileToTrash.exists()) {
            fileToTrash.delete();
        }
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
