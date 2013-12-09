package com.supinfo.supcrowdfunder.servlet.categorie;

import com.supinfo.supcrowdfunder.dao.CategorieDao;
import com.supinfo.supcrowdfunder.entity.Categorie;
import com.supinfo.supcrowdfunder.form.AddCategorieType;
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
 * Date: 27/11/13
 * Time: 13:30
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "EditCategorieBOServlet", urlPatterns = {"/bo/categorie/edit"})
public class EditCategorieBOServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FlashBag flashbag = (FlashBag) request.getAttribute("flashbag");
        Long id = request.getParameter("id") != null ? Long.parseLong(request.getParameter("id")) : null;
        Categorie categorie = null;
        if (id != null && id > 0)
            categorie = CategorieDao.findOne(id);
        if (categorie == null) {
            flashbag.addFlash("warning", "bo.page.categorie.notExist");
            response.sendRedirect(request.getContextPath()+"/bo/categorie");
        } else {
            AddCategorieType form = new AddCategorieType();
            form.validate(request);
            categorie = form.fill(categorie, request);
            if (form.getResult()) {
                form.persistEdit(categorie);
                flashbag.addFlash("success", "flash.addCategorie.success");
            } else {
                request.setAttribute("errors", form.getErrors());
                request.setAttribute("result", form.getResult());
                flashbag.addFlash("danger", "flash.addCategorie.error");
            }
            request.setAttribute("categorie", categorie);
            this.getServletContext().getRequestDispatcher("/WEB-INF/bo/categorie/edit.jsp").forward(request, response);
        }
    }

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
            this.getServletContext().getRequestDispatcher("/WEB-INF/bo/categorie/edit.jsp").forward(request, response);
        }
    }
}