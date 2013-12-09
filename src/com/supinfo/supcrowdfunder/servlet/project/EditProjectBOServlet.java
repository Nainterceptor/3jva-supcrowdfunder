package com.supinfo.supcrowdfunder.servlet.project;

import com.supinfo.supcrowdfunder.dao.CategorieDao;
import com.supinfo.supcrowdfunder.dao.ProjectDao;
import com.supinfo.supcrowdfunder.entity.Project;
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
 * Time: 17:27
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "EditProjectBOServlet", urlPatterns = "/bo/project/edit")
public class EditProjectBOServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = request.getParameter("id") != null ? Long.parseLong(request.getParameter("id")) : null;
        Project project = null;
        FlashBag flashbag = (FlashBag) request.getAttribute("flashbag");
        if (id != null && id > 0)
            project = ProjectDao.findProjectById(id);
        if (project == null) {
            flashbag.addFlash("warning", "bo.page.project.notExist");
            response.sendRedirect(request.getContextPath()+"/bo/project");
        } else {
            CreateProjectType form = new CreateProjectType();
            form.validate(request);
            request.setAttribute("categories", CategorieDao.getAll());
            request.setAttribute("project", project);
            if (form.getResult()) {
                form.merge(project, request);
                flashbag.addFlash("success", "bo.flash.project.edit.success");
                response.sendRedirect(request.getContextPath()+"/bo/project");
            } else {
                request.setAttribute("errors", form.getErrors());
                request.setAttribute("result", form.getResult());
                flashbag.addFlash("danger", "bo.flash.project.edit.error");
                this.getServletContext().getRequestDispatcher("/WEB-INF/bo/project/edit.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = request.getParameter("id") != null ? Long.parseLong(request.getParameter("id")) : null;
        Project project = null;
        FlashBag flashbag = (FlashBag) request.getAttribute("flashbag");
        if (id != null && id > 0)
            project = ProjectDao.findProjectById(id);
        if (project == null) {
            flashbag.addFlash("warning", "bo.page.project.notExist");
            response.sendRedirect(request.getContextPath()+"/bo/project");
        } else {
            request.setAttribute("project", project);
            request.setAttribute("categories", CategorieDao.getAll());
            this.getServletContext().getRequestDispatcher("/WEB-INF/bo/project/edit.jsp").forward(request, response);
        }
    }
}
