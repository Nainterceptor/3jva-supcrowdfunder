package com.supinfo.supcrowdfunder.servlet.project;

import com.supinfo.supcrowdfunder.dao.ProjectDao;
import com.supinfo.supcrowdfunder.dao.StatisticDao;
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
 * User: Fireaxe
 * Date: 26/11/13
 * Time: 14:30
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "ShowProjectServlet", urlPatterns = {"/project/show"})
public class ShowProjectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = request.getParameter("id") != null ? Long.parseLong(request.getParameter("id")) : null;
        Project project = null;
        Long actualCredit = null;
        if (id != null && id > 0){
            project = ProjectDao.findProjectById(id);
            actualCredit = StatisticDao.sumContributes(id);
            request.setAttribute("actualCredits", actualCredit);
        }
        if (project == null) {
            ((FlashBag) request.getAttribute("flashbag")).addFlash("warning", "show.page.project.notExist");
            response.sendRedirect("/project");
        } else {
            request.setAttribute("project", project);
            this.getServletContext().getRequestDispatcher("/WEB-INF/project/show.jsp").forward(request, response);
        }
    }
}
