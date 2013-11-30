package com.supinfo.supcrowdfunder.servlet.contribute;

import com.supinfo.supcrowdfunder.dao.ContributeDao;
import com.supinfo.supcrowdfunder.entity.Contribute;
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
 * Time: 23:17
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "DeleteContributeBOServlet", urlPatterns = "/bo/contribute/delete")
public class DeleteContributeBOServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = request.getParameter("id") != null ? Long.parseLong(request.getParameter("id")) : null;
        Contribute contribute = null;
        FlashBag flashbag = (FlashBag) request.getAttribute("flashbag");
        if (id != null && id > 0)
            contribute = ContributeDao.findOne(id);
        if (contribute == null) {
            flashbag.addFlash("warning", "bo.page.contribute.notExist");
        } else {
            ((FlashBag) request.getAttribute("flashbag")).addFlash("warning", "bo.flash.contribute.delete.success");
            ContributeDao.removeOne(id);
        }
        response.sendRedirect("/bo/contribute");
    }
}
