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
 * Date: 02/12/13
 * Time: 21:37
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "ShowContributeBOServlet", urlPatterns = "/bo/contribute/show")
public class ShowContributeBOServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = request.getParameter("id") != null ? Long.parseLong(request.getParameter("id")) : null;
        Contribute contribute = null;
        if (id != null && id > 0)
            contribute = ContributeDao.findOne(id);
        if (contribute == null) {
            ((FlashBag) request.getAttribute("flashbag")).addFlash("warning", "bo.page.contribute.notExist");
            response.sendRedirect("/bo/contribute");
        } else {
            request.setAttribute("contribute", contribute);
            this.getServletContext().getRequestDispatcher("/WEB-INF/bo/contribute/show.jsp").forward(request, response);
        }
    }
}
