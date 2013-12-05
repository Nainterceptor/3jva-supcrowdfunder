package com.supinfo.supcrowdfunder.dao;

import com.supinfo.supcrowdfunder.entity.Categorie;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * User: Romain Letrémy
 * Date: 25/11/13
 * Time: 15:16
 */

public class CategorieDao extends AbstractDao {
    public static List<Categorie> getAll() {

        Query query = DaoRessource.getEm().createQuery("SELECT c FROM Categorie c");
        List<Categorie> categories = query.getResultList();
        return categories;
    }

    public static Categorie findOne(Long id) {

        Categorie result = DaoRessource.getEm().find(Categorie.class, id);
        return result;
    }

    public static void insertOne(String name) throws Exception {

        try {
            Categorie oneCategorie = new Categorie()
                    .setName(name);
            persist(oneCategorie);
        } catch (Exception e) {
            throw new Exception("Internal : Can't register categorie");
        }
    }

    public static boolean isNameExist(String name) {
        Query query = DaoRessource.getEm().createQuery("SELECT COUNT(c) as count FROM Categorie c WHERE c.name = :name", Long.class)
                .setParameter("name", name);
        long result = (Long) query.getSingleResult();

        return result > 0;
    }

    public static void removeOne(Long id) {
        EntityManager em = DaoRessource.getEm();
        em.getTransaction().begin();
        em.createQuery("DELETE Categorie WHERE id = :categorieId")
                .setParameter("categorieId", id)
                .executeUpdate();
        em.getTransaction().commit();
    }
}
