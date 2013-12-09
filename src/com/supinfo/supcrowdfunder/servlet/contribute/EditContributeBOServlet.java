package com.supinfo.supcrowdfunder.servlet.contribute;

import com.supinfo.supcrowdfunder.dao.ContributeDao;
import com.supinfo.supcrowdfunder.entity.Contribute;
import com.supinfo.supcrowdfunder.form.CreateContributeType;
import com.supinfo.supcrowdfunder.util.FlashBag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Robin
 * Date: 30/11/13
 * Time: 18:15
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "EditContributeBOServlet", urlPatterns = "/bo/contribute/edit")
public class EditContributeBOServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = request.getParameter("id") != null ? Long.parseLong(request.getParameter("id")) : null;
        Contribute contribute = null;
        FlashBag flashbag = (FlashBag) request.getAttribute("flashbag");
        if (id != null && id > 0)
            contribute = ContributeDao.findOne(id);
        if (contribute == null) {
            flashbag.addFlash("warning", "bo.page.contribute.notExist");
            response.sendRedirect(request.getContextPath()+"/bo/contribute");
        } else {
            request.setAttribute("contribute", contribute);
            CreateContributeType form = new CreateContributeType();
            form.validate(request);
            if (form.getResult()) {
                form.merge(request);
                flashbag.addFlash("success", "bo.flash.contribute.edit.success");
                response.sendRedirect(request.getContextPath()+"/bo/contribute");
            } else {
                request.setAttribute("errors", form.getErrors());
                request.setAttribute("result", form.getResult());
                flashbag.addFlash("danger", "bo.flash.contribute.edit.error");
                this.getServletContext().getRequestDispatcher("/WEB-INF/bo/contribute/edit.jsp").forward(request, response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = request.getParameter("id") != null ? Long.parseLong(request.getParameter("id")) : null;
        Contribute contribute = null;
        FlashBag flashbag = (FlashBag) request.getAttribute("flashbag");
        if (id != null && id > 0)
            contribute = ContributeDao.findOne(id);
        if (contribute == null) {
            flashbag.addFlash("warning", "bo.page.contribute.notExist");
            response.sendRedirect(request.getContextPath()+"/bo/contribute");
        } else {
            request.setAttribute("contribute", contribute);
            this.getServletContext().getRequestDispatcher("/WEB-INF/bo/contribute/edit.jsp").forward(request, response);
        }

    }
}
