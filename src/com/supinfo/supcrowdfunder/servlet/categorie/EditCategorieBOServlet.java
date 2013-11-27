//package com.supinfo.supcrowdfunder.servlet.categorie;
//
//import com.supinfo.supcrowdfunder.dao.CategorieDao;
//import com.supinfo.supcrowdfunder.entity.Categorie;
//import com.supinfo.supcrowdfunder.form.CategorieType;
//import com.supinfo.supcrowdfunder.util.FlashBag;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
///**
// * Created with IntelliJ IDEA.
// * User: Romain Letrémy
// * Date: 27/11/13
// * Time: 13:29
// * To change this template use File | Settings | File Templates.
// */
//@WebServlet(name = "EditCategorieBOServlet", urlPatterns = {"/bo/categorie/edit"})
//public class EditCategorieBOServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Long id = request.getParameter("id") != null ? Long.parseLong(request.getParameter("id")) : null;
//        Categorie categorie = null;
//        FlashBag flashbag = (FlashBag) request.getAttribute("flashbag");
//        if (id != null && id > 0)
//            categorie = CategorieDao.findOne(id);
//        if (categorie == null) {
//            flashbag.addFlash("warning", "bo.page.categorie.notExist");
//            response.sendRedirect("/bo/categorie");
//        } else {
//            CategorieType form = new CategorieType();
//            form.validate(request);
//            categorie = form.fill(categorie, request);
//            if (form.getResult()) {
//
//                form.persist(categorie);
//                flashbag.addFlash("success", "flash.bo.categorie.edit.success");
//            } else {
//                request.setAttribute("errors", form.getErrors() );
//                request.setAttribute("result", form.getResult());
//                flashbag.addFlash("danger", "flash.bo.categorie.edit.error");
//            }
//            request.setAttribute("categorie", categorie);
//            this.getServletContext().getRequestDispatcher("/WEB-INF/bo/categorie/edit.jsp").forward(request, response);
//        }
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Long id = request.getParameter("id") != null ? Long.parseLong(request.getParameter("id")) : null;
//        Categorie categorie = null;
//        if (id != null && id > 0)
//            categorie = CategorieDao.findOne(id);
//        if (categorie == null) {
//            ((FlashBag) request.getAttribute("flashbag")).addFlash("warning", "bo.page.categorie.notExist");
//            response.sendRedirect("/bo/categorie");
//        } else {
//            request.setAttribute("categorie", categorie);
//            this.getServletContext().getRequestDispatcher("/WEB-INF/bo/categorie/edit.jsp").forward(request, response);
//        }
//    }
//}
