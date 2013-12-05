package com.supinfo.supcrowdfunder.servlet.categorie;

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
 * User: Romain Letrémy
 * Date: 27/11/13
 * Time: 14:40
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "AddCategorieBOServlet", urlPatterns = {"/bo/categorie/add"})
public class AddCategorieBOServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AddCategorieType form = new AddCategorieType();
        form.validate(request);
        FlashBag flashbag = (FlashBag) request.getAttribute("flashbag");
        if (form.getResult()) {
            form.persist(request);
            flashbag.addFlash("success", "flash.addCategorie.success");
            //redirect
            response.sendRedirect("/bo/categorie");
        } else {
            request.setAttribute("errors", form.getErrors());
            request.setAttribute("result", form.getResult());
            flashbag.addFlash("danger", "flash.addCategorie.error");
            this.getServletContext().getRequestDispatcher("/WEB-INF/bo/categorie/addCategorie.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/bo/categorie/addCategorie.jsp").forward(request, response);
    }
}
