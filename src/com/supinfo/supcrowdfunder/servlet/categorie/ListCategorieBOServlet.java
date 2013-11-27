package com.supinfo.supcrowdfunder.servlet.categorie;

import com.supinfo.supcrowdfunder.dao.CategorieDao;
import com.supinfo.supcrowdfunder.entity.Categorie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Romain Letrémy
 * Date: 27/11/13
 * Time: 13:28
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "ListCategorieBOServlet", urlPatterns = {"/bo/categorie"})
public class ListCategorieBOServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Categorie> categories = CategorieDao.getAll();
        request.setAttribute("categories", categories);
        this.getServletContext().getRequestDispatcher("/WEB-INF/bo/categorie/list.jsp").forward(request, response);
    }
}
