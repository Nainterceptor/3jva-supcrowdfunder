package com.supinfo.supcrowdfunder.servlet.project;

import com.supinfo.supcrowdfunder.dao.CategorieDao;
import com.supinfo.supcrowdfunder.dao.ProjectDao;
import com.supinfo.supcrowdfunder.entity.Project;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Fireaxe
 * Date: 22/11/13
 * Time: 02:45
 * To change this template use File | Settings | File Templates.
 */

@WebServlet(name = "IndexProjectServlet", urlPatterns = {"/project"})
public class IndexProjectServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category = request.getParameter("category");
        List<Project> projects;
        if (category == null)
            projects = ProjectDao.getAll();
        else
            projects = ProjectDao.getAll(Long.parseLong(category));

        request.setAttribute("projects", projects);
        request.setAttribute("categories", CategorieDao.getAll());

        this.getServletContext().getRequestDispatcher("/WEB-INF/project/list.jsp").forward(request, response);
    }
}
