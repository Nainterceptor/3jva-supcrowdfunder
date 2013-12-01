package com.supinfo.supcrowdfunder.servlet.project;

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
 * User: Robin
 * Date: 01/12/13
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "ListProjectsBOServlet", urlPatterns = "/bo/project")
public class ListProjectsBOServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Project> projects = ProjectDao.getAll();
        request.setAttribute("projects", projects);
        this.getServletContext().getRequestDispatcher("/WEB-INF/bo/project/list.jsp").forward(request, response);
    }
}
