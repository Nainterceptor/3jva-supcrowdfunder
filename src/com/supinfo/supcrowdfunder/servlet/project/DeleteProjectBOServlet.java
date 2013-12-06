package com.supinfo.supcrowdfunder.servlet.project;

import com.supinfo.supcrowdfunder.dao.ProjectDao;
import com.supinfo.supcrowdfunder.entity.Project;
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
 * Time: 20:07
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "DeleteProjectBOServlet", urlPatterns = "/bo/project/delete")
public class DeleteProjectBOServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = request.getParameter("id") != null ? Long.parseLong(request.getParameter("id")) : null;
        Project project = null;
        FlashBag flashbag = (FlashBag) request.getAttribute("flashbag");
        if (id != null && id > 0)
            project = ProjectDao.findProjectById(id);
        if (project == null) {
            flashbag.addFlash("warning", "bo.page.project.notExist");
        } else {
            try {
                 ProjectDao.removeOne(id);
                ((FlashBag) request.getAttribute("flashbag")).addFlash("warning", "bo.flash.project.delete.success");
            } catch (Exception e){
                ((FlashBag) request.getAttribute("flashbag")).addFlash("danger", "bo.flash.project.delete.error");
            }
        }
        response.sendRedirect("/bo/project");
    }
}
