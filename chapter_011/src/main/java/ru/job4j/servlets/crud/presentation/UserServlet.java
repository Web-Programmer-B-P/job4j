package ru.job4j.servlets.crud.presentation;

import ru.job4j.servlets.crud.logic.Validate;
import ru.job4j.servlets.crud.logic.ValidateService;
import ru.job4j.servlets.crud.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class UserServlet extends HttpServlet {
    private final Validate logic = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter view = resp.getWriter();
        view.append("<html>")
                .append("<table border='1' width='100%' cellpadding='5'>")
                .append("<tr>")
                .append("<td>Id:</td>")
                .append("<td>Name:</td>")
                .append("<td>Login:</td>")
                .append("<td>Email:</td>")
                .append("<td>Create date:</td>")
                .append("<td>Edit</td>")
                .append("<td>Delete</td>")
                .append("</tr>");
        for (User el : logic.findAll()) {
            int id = el.getId();
            view.append("<tr>")
                    .append("<td>").append(String.valueOf(id)).append("</td>")
                    .append("<td>").append(el.getName()).append("</td>")
                    .append("<td>").append(el.getLogin()).append("</td>")
                    .append("<td>").append(el.getEmail()).append("</td>")
                    .append("<td>").append(String.valueOf(getDate(el.getCreateDate()))).append("</td>")
                    .append("<form action=").append(req.getContextPath()).append("/edit method='GET'>")
                    .append("<input type='hidden' name='id' value='").append(String.valueOf(el.getId())).append("'>")
                    .append("<td><input type='submit' value='Edit' class='submit'></td>")
                    .append("</form>")
                    .append("<form action=").append(req.getContextPath()).append("/list method='POST'>")
                    .append("<input type='hidden' name='action' value='delete'>")
                    .append("<input type='hidden' name='id' value='").append(String.valueOf(el.getId())).append("'>")
                    .append("<td><input type='submit' value='Delete' class='submit'></td>")
                    .append("</form>")
                    .append("</tr>");
        }
        view.append("</table>")
                .append("<h3 style='text-align:center;'><a href='")
                .append(req.getContextPath())
                .append("/create' style='text-decoration:none; color:orange'>Create user</a></h3>")
                .append("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = req.getParameter("action");
        String idParam = req.getParameter("id");
        int id = 0;
        if (action.equals("add")) {
            User user = new User(logic.getNewId());
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

    private Date getDate(long time) {
        return new Date(time);
    }
}
