package com.supinfo.supcrowdfunder.servlet;

import com.supinfo.supcrowdfunder.dao.StatisticDao;
import com.supinfo.supcrowdfunder.form.IndexBoType;
import com.supinfo.supcrowdfunder.util.FlashBag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Author: Gaël Demette
 * Date: 28/11/13
 * Time: 19:50
 */
@WebServlet(name = "IndexBOServlet", urlPatterns = {"/bo/", "/bo"})
public class IndexBOServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IndexBoType form = new IndexBoType();
        form.validate(request);
        FlashBag flashbag = (FlashBag) request.getAttribute("flashbag");
        Map<String, Long> statsGlobal;
        if (form.getResult()) {
            statsGlobal = form.chooseMethodDao();
        } else {
            request.setAttribute("errors", form.getErrors());
            request.setAttribute("result", form.getResult());
            flashbag.addFlash("danger", "bo.flash.index.search.error");
            statsGlobal = StatisticDao.findGlobalStats();
        }
        request.setAttribute("statsGlobal", statsGlobal);
        this.getServletContext().getRequestDispatcher("/WEB-INF/bo/index.jsp").forward(request, response);
    }
}
