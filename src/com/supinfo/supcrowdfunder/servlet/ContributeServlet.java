package com.supinfo.supcrowdfunder.servlet;

import com.supinfo.supcrowdfunder.form.ContributeType;

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
        System.out.println("Je suis dans le servlet" + request.getParameter("projectId"));
        if (request.getParameter("projectId") == null){
            response.sendRedirect("/project");
        }

        else if (request.getParameter("amount") == null) {
            this.getServletContext().getRequestDispatcher("/WEB-INF/contribute.jsp").forward(request, response);
            System.out.println("Je suis dans le amount null");
        }
        else{
            System.out.println("Je suis passé, project id vaut : " + request.getParameter("projectId") + " et amount vaut : " + request.getParameter("amount"));
            ContributeType form = new ContributeType();
            form.validate(request);
            System.out.println("Voici le result : " + form.getResult());
            if(form.getResult()) {
                form.persist(request);
            } else {
                request.setAttribute("errors", form.getErrors());
                request.setAttribute("result", form.getResult());
            }

            this.getServletContext().getRequestDispatcher("/WEB-INF/contribute.jsp").forward(request, response);
        }
    }
}

