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

public class UserUpdateServlet extends HttpServlet {
    private final Validate logic = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam != null) {
            User userForEdit = logic.findById(Integer.parseInt(idParam));
            PrintWriter view = resp.getWriter();
            view.append("<html>")
                    .append("<div style='text-align:center;'>")
                    .append("<h1>Page for edit user</h1>")
                    .append("<form action=").append(req.getContextPath()).append("/list method='POST'>")
                    .append("<p><strong>Name: </strong>")
                    .append("<input name='name' placeholder='Name' value='").append(userForEdit.getName()).append("'></p>")
                    .append("<p><strong>Login: </strong>")
                    .append("<input name='login' placeholder='Login' value='").append(userForEdit.getLogin()).append("'></p>")
                    .append("<p><strong>Email: </strong>")
                    .append("<input name='email' placeholder='Email' value='").append(userForEdit.getEmail()).append("'></p>")
                    .append("<input type='hidden' name='action' value='update'>")
                    .append("<input type='hidden' name='id' value='").append(idParam).append("'>")
                    .append("<p><input type='submit' value='Save'></p>")
                    .append("</form>")
                    .append("</div>")
                    .append("</html>");
        }
    }
}
