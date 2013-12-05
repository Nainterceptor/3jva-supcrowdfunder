package com.supinfo.supcrowdfunder.servlet.project;

import com.supinfo.supcrowdfunder.dao.CategorieDao;
import com.supinfo.supcrowdfunder.form.AddProjectType;
import com.supinfo.supcrowdfunder.util.FlashBag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Fireaxe
 * Date: 22/11/13
 * Time: 02:36
 * To change this template use File | Settings | File Templates.
 */

@WebServlet(name = "AddProjectServlet", urlPatterns = {"/me/project/add"})
public class AddProjectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AddProjectType form = new AddProjectType();
        form.validate(request);
        request.setAttribute("categories", CategorieDao.getAll());
        FlashBag flashbag = (FlashBag) request.getAttribute("flashbag");
        if (form.getResult()) {
            form.persist(request);
            flashbag.addFlash("success", "flash.project.success");
        } else {
            request.setAttribute("errors", form.getErrors());
            request.setAttribute("result", form.getResult());
            flashbag.addFlash("danger", "flash.project.error");
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/project/add.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categories", CategorieDao.getAll());

        this.getServletContext().getRequestDispatcher("/WEB-INF/project/add.jsp").forward(request, response);
    }
}
