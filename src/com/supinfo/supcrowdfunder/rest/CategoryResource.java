package com.supinfo.supcrowdfunder.rest;

import com.supinfo.supcrowdfunder.dao.CategorieDao;
import com.supinfo.supcrowdfunder.entity.Categorie;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Author: Gaël Demette
 * Date: 11/12/13
 * Time: 14:00
 */
@Path("/category")
public class CategoryResource {
    @GET @Path("/all") @Produces(MediaType.APPLICATION_XML)
    public List<Categorie> getCategories() {
        return CategorieDao.getAll();
    }
    @GET @Path("/{id}") @Produces(MediaType.APPLICATION_XML)
    public Categorie getCategory(@PathParam("id") Long id) {
        return CategorieDao.findOne(id);
    }
}
