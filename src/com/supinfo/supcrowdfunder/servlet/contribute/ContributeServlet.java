package com.supinfo.supcrowdfunder.servlet.contribute;

import com.supinfo.supcrowdfunder.dao.ProjectDao;
import com.supinfo.supcrowdfunder.form.ContributeType;
import com.supinfo.supcrowdfunder.util.FlashBag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// * Created with IntelliJ IDEA.
// * User: Robin
// * Date: 27/11/13
// * Time: 00:28
// * To change this template use File | Settings | File Templates.

@WebServlet(name = "ContributeServlet", urlPatterns="/me/contribute")
public class ContributeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FlashBag flashbag = (FlashBag) request.getAttribute("flashbag");
        if (request.getParameter("projectId") == null){
            response.sendRedirect("/project");
            flashbag.addFlash("danger", "flash.contribute.projectId.fail");
        }
        else{
            ContributeType form = new ContributeType();
            form.validate(request);
            request.setAttribute("projectName", ProjectDao.findProjectById(Long.parseLong(request.getParameter("projectId"))).getName());
            if(form.getResult()) {
                form.persist(request);
                flashbag.addFlash("success", "flash.contribute.success");
                this.getServletContext().getRequestDispatcher("/WEB-INF/contribute/thanks.jsp").forward(request, response);
            } else {
                request.setAttribute("errors", form.getErrors());
                request.setAttribute("result", form.getResult());
                flashbag.addFlash("danger", "flash.contribute.error");
                String path = ("/project/show?id="+(request.getParameter("projectId")));
                this.getServletContext().getRequestDispatcher(path).forward(request, response);
            }
        }
    }
}

