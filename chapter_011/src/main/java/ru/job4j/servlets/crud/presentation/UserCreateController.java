package ru.job4j.servlets.crud.presentation;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class UserCreateController extends HttpServlet {
    private static final int INDEX_OF_FIRST_ELEMENT_FROM_REQUEST = 0;
    protected static final String PATH_TO_SAVE_IMAGES = "/home/proger/bin/images/";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File privateUserFile = new File(PATH_TO_SAVE_IMAGES + File.separator + req.getAttribute("fileName"));
        if (privateUserFile.exists()) {
            req.setAttribute("image", privateUserFile.getName());
        }
        req.getRequestDispatcher("WEB-INF/views/create/create.jsp").forward(req, resp);
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
                req.setAttribute("fileName", item.getName());
                File file = new File(targetFolderToSave + File.separator + item.getName());
                try (FileOutputStream out = new FileOutputStream(file)) {
                    out.write(item.getInputStream().readAllBytes());
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        doGet(req, resp);
    }
}
