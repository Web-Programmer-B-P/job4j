package ru.job4j.servlets.crud.presentation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserCreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            PrintWriter view = resp.getWriter();
            view.append("<html>")
                    .append("<div style='text-align:center;'>")
                    .append("<h1>Create user</h1>")
                    .append("<form action=").append(req.getContextPath()).append("/list method='POST'>")
                    .append("<p><strong>Name: </strong>")
                    .append("<input name='name' placeholder='Name' value=' '></p>")
                    .append("<p><strong>Login: </strong>")
                    .append("<input name='login' placeholder='Login' value=' '></p>")
                    .append("<p><strong>Email: </strong>")
                    .append("<input name='email' placeholder='Email' value=' '></p>")
                    .append("<input type='hidden' name='action' value='add'>")
                    .append("<p><input type='submit' value='Save'></p>")
                    .append("</form>")
                    .append("</div>")
                    .append("</html>");
    }
}
