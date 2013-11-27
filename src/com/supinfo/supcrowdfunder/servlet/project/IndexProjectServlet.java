package com.supinfo.supcrowdfunder.servlet.project;

import com.supinfo.supcrowdfunder.dao.CategorieDao;
import com.supinfo.supcrowdfunder.dao.ProjectDao;

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
 * Time: 02:45
 * To change this template use File | Settings | File Templates.
 */

@WebServlet(name = "IndexProjectServlet", urlPatterns = {"/project"})
public class IndexProjectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/WEB-INF/project/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("projects", ProjectDao.getAll());
        request.setAttribute("categories", CategorieDao.getAll());

        this.getServletContext().getRequestDispatcher("/WEB-INF/project/list.jsp").forward(request, response);
    }
}
