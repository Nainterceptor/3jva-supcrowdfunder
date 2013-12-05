package com.supinfo.supcrowdfunder.servlet.project;

import com.supinfo.supcrowdfunder.dao.CategorieDao;
import com.supinfo.supcrowdfunder.form.CreateProjectType;
import com.supinfo.supcrowdfunder.util.FlashBag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Robin
 * Date: 01/12/13
 * Time: 18:54
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "CreateProjectBOServlet", urlPatterns = "/bo/project/create")
public class CreateProjectBOServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FlashBag flashbag = (FlashBag) request.getAttribute("flashbag");
        CreateProjectType form = new CreateProjectType();
        form.validate(request);
        if (form.getResult()) {
            form.persist(request);
            flashbag.addFlash("success", "bo.flash.project.edit.success");
        } else {
            request.setAttribute("errors", form.getErrors());
            request.setAttribute("result", form.getResult());

            flashbag.addFlash("danger", "bo.flash.project.edit.error");
        }
        request.setAttribute("categories", CategorieDao.getAll());
        this.getServletContext().getRequestDispatcher("/WEB-INF/bo/project/create.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categories", CategorieDao.getAll());
        this.getServletContext().getRequestDispatcher("/WEB-INF/bo/project/create.jsp").forward(request, response);
    }
}
