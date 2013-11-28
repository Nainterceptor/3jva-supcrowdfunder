package com.supinfo.supcrowdfunder.servlet.contribute;

import com.supinfo.supcrowdfunder.dao.ContributeDao;
import com.supinfo.supcrowdfunder.entity.Contribute;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Robin
 * Date: 28/11/13
 * Time: 14:52
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "ListContributesBOServlet", urlPatterns = "/bo/contribute")
public class ListContributesBOServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contribute> contributes = ContributeDao.getAll();
        request.setAttribute("contributes", contributes);
        this.getServletContext().getRequestDispatcher("/WEB-INF/bo/contribute/list.jsp").forward(request, response);

    }
}
