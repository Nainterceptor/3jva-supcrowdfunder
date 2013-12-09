package com.supinfo.supcrowdfunder.servlet.user;

import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.entity.User;
import com.supinfo.supcrowdfunder.util.FlashBag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: Gaël Demette
 * Date: 27/11/13
 * Time: 16:57
 */
@WebServlet(name = "DeleteUserBOServlet", urlPatterns = {"/bo/user/delete"})
public class DeleteUserBOServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = request.getParameter("id") != null ? Long.parseLong(request.getParameter("id")) : null;
        User user = null;
        if (id != null && id > 0)
            user = UserDao.findOne(id);
        if (user == null) {
            ((FlashBag) request.getAttribute("flashbag")).addFlash("warning", "bo.page.user.notExist");
        } else {
            try {
                UserDao.removeOne(id);
                ((FlashBag) request.getAttribute("flashbag")).addFlash("warning", "bo.flash.user.delete.success");
            } catch (Exception e){
                ((FlashBag) request.getAttribute("flashbag")).addFlash("danger", "bo.flash.user.delete.error");
            }
        }
        response.sendRedirect(request.getContextPath()+"/bo/user");
    }
}
