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
 * User: Romain Letrémy
 * Date: 27/11/13
 * Time: 13:30
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "DeleteCategorieBOServlet", urlPatterns = {"/bo/categorie/delete"})
public class DeleteCategorieBOServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = request.getParameter("id") != null ? Long.parseLong(request.getParameter("id")) : null;
        Categorie categorie = null;
        if (id != null && id > 0)
            categorie = CategorieDao.findOne(id);
        if (categorie == null) {
            ((FlashBag) request.getAttribute("flashbag")).addFlash("warning", "bo.page.categorie.notExist");
        } else {
            ((FlashBag) request.getAttribute("flashbag")).addFlash("warning", "bo.flash.categorie.delete.success");
            CategorieDao.removeOne(id);
        }
        response.sendRedirect("/bo/categorie");
    }
}
