package com.supinfo.supcrowdfunder.servlet.categorie;

import com.supinfo.supcrowdfunder.dao.CategorieDao;
import com.supinfo.supcrowdfunder.entity.Categorie;
import com.supinfo.supcrowdfunder.util.FlashBag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Romain-x1300
 * Date: 30/11/13
 * Time: 17:25
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "ShowCategorieBOServlet", urlPatterns = {"/bo/categorie/show"})
public class ShowCategorieBOServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = request.getParameter("id") != null ? Long.parseLong(request.getParameter("id")) : null;
        Categorie categorie = null;
        if (id != null && id > 0)
            categorie = CategorieDao.findOne(id);
        if (categorie == null) {
            ((FlashBag) request.getAttribute("flashbag")).addFlash("warning", "bo.page.categorie.notExist");
            response.sendRedirect(request.getContextPath()+"/bo/categorie");
        } else {
            request.setAttribute("categorie", categorie);
            this.getServletContext().getRequestDispatcher("/WEB-INF/bo/categorie/show.jsp").forward(request, response);
        }
    }
}
