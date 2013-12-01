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
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "ShowProjectBOServlet", urlPatterns = "/bo/project/show")
public class ShowProjectBOServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = request.getParameter("id") != null ? Long.parseLong(request.getParameter("id")) : null;
        Project project = null;
        if (id != null && id > 0)
            project = ProjectDao.findProjectById(id);
        if (project == null) {
            ((FlashBag) request.getAttribute("flashbag")).addFlash("warning", "bo.page.project.notExist");
            response.sendRedirect("/bo/project");
        } else {
            request.setAttribute("project", project);
            this.getServletContext().getRequestDispatcher("/WEB-INF/bo/project/show.jsp").forward(request, response);
        }

    }
}
