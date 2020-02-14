package ru.job4j.servlets.crud.presentation.user;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.servlets.crud.persistent.db.DbUserStore;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class SingleUserUpdateFileController extends HttpServlet {
    private static final Logger LOG = LogManager.getLogger(DbUserStore.class.getName());
    private static final int INDEX_OF_FIRST_ELEMENT_FROM_REQUEST = 0;
    protected static final String PATH_TO_SAVE_IMAGES = "/home/proger/bin/images/";
    private static final String ATTRIBUTE_FILE_NAME = "fileName";
    private static final String MESSAGE_LOG = "Смотри в метод загрузки файла";
    private static final String IMAGE_ATTRIBUTE = "image";
    private String id;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File privateUserFile = new File(PATH_TO_SAVE_IMAGES + File.separator + req.getAttribute(ATTRIBUTE_FILE_NAME));
        if (privateUserFile.exists()) {
            req.setAttribute(IMAGE_ATTRIBUTE, privateUserFile.getName());
            req.setAttribute("id", id);
        }
        id = req.getParameter("id");
        req.getRequestDispatcher(String.format("%s%s", req.getContextPath(), "WEB-INF/views/user/update_file_user_page.jsp")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        File repository = (File) this.getServletConfig().getServletContext().getAttribute(ServletContext.TEMPDIR);
        factory.setRepository(repository);
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            FileItem item = upload.parseRequest(req).get(INDEX_OF_FIRST_ELEMENT_FROM_REQUEST);
            File targetFolderToSave = new File(PATH_TO_SAVE_IMAGES);
            if (!targetFolderToSave.exists()) {
                targetFolderToSave.mkdir();
            }
            if (!item.isFormField()) {
                req.setAttribute(ATTRIBUTE_FILE_NAME, item.getName());
                File file = new File(targetFolderToSave + File.separator + item.getName());
                try (FileOutputStream out = new FileOutputStream(file)) {
                    out.write(item.getInputStream().readAllBytes());
                }
            }
        } catch (FileUploadException e) {
            LOG.error(MESSAGE_LOG, e);
        }
        doGet(req, resp);
    }
}
