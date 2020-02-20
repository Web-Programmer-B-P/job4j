package ru.job4j.servlets.crud.presentation.autorisation;

import ru.job4j.servlets.crud.logic.user.Validate;
import ru.job4j.servlets.crud.logic.user.ValidateUserService;
import ru.job4j.servlets.crud.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SingInController extends HttpServlet {
    private static final Validate LOGIC = ValidateUserService.getInstance();
    private static final String PATH_TO_SING_IN_JSP = "WEB-INF/views/singin/sing_in.jsp";
    private static final String LOGIN_PARAMETER = "login";
    private static final String PASSWORD_PARAMETER = "password";
    private static final String LIST_URI = "/list";
    private static final String ERROR_MESSAGE = "Пользователя с таким логином и паролем не найдено!";
    private static final String ERROR_ATTRIBUTE = "error";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PATH_TO_SING_IN_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN_PARAMETER);
        String password = req.getParameter(PASSWORD_PARAMETER);
        if (LOGIC.isUserExist(login, password)) {
            User checkedUser = LOGIC.findByLoginAndPassword(login, password);
            HttpSession session = req.getSession();
            session.setAttribute("user", checkedUser);
            if (checkedUser.getRoleName().equals("admin")) {
                resp.sendRedirect(String.format("%s%s", req.getContextPath(), LIST_URI));
            } else {
                resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/page_user"));
            }
        } else {
            req.setAttribute(ERROR_ATTRIBUTE, ERROR_MESSAGE);
            doGet(req, resp);
        }
    }
}
