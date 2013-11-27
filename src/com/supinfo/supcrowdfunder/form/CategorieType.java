//package com.supinfo.supcrowdfunder.form;
//
//import com.supinfo.supcrowdfunder.dao.CategorieDao;
//import com.supinfo.supcrowdfunder.entity.Categorie;
//import com.supinfo.supcrowdfunder.util.SecurityHelper;
//import com.supinfo.supcrowdfunder.validator.CategorieValidator;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * Created with IntelliJ IDEA.
// * User: RomainStudent
// * Date: 27/11/13
// * Time: 18:31
// * To change this template use File | Settings | File Templates.
// */
//public class CategorieType {
//    public void persist(Categorie categorie) {
//        try {
//            CategorieDao.persist(categorie);
//        } catch (Exception e) {
//            errors.put("internal", e.getMessage());
//            result = false;
//        }
//    }
//    public Categorie fill(Categorie categorie, HttpServletRequest request) {
//        String password = request.getParameter("password");
//        if (password != null && password.length() > 0) {
//            String salt = SecurityHelper.generateSalt();
//            try {
//                categorie.setSalt(salt).setPassword(SecurityHelper.hashPassword(password, salt));
//            } catch (Exception e) {
//                errors.put("internal", "Hash failed");
//            }
//        }
//        String name = request.getParameter("name");
//        categorie.setName(name);
//
//        System.out.println("fill");
//        return categorie;
//    }
//    public void validate(HttpServletRequest request) {
//        try {
//            CategorieValidator.lastname(request.getParameter("name"));
//        } catch (Exception e) {
//            errors.put("name", e.getMessage());
//        }
//        if (!errors.isEmpty())
//            result = false;
//    }
//}
