package com.supinfo.supcrowdfunder.servlet.contribute;

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
 * Date: 28/11/13
 * Time: 19:13
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "CreateContributeBOServlet", urlPatterns = "/bo/contribute/create")
public class CreateContributeBOServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FlashBag flashbag = (FlashBag) request.getAttribute("flashbag");
        CreateContributeType form = new CreateContributeType();
        form.validate(request);
        if (form.getResult()) {
            form.persist(request);
            flashbag.addFlash("success", "bo.flash.contribute.edit.success");
        } else {
            request.setAttribute("errors", form.getErrors() );
            request.setAttribute("result", form.getResult());
            flashbag.addFlash("danger", "bo.flash.contribute.edit.error");
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/bo/contribute/create.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/bo/contribute/create.jsp").forward(request, response);
    }
}
