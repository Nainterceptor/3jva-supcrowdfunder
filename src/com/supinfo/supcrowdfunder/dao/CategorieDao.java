package com.supinfo.supcrowdfunder.dao;

import com.supinfo.supcrowdfunder.entity.Categorie;

import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Romain Letrémy
 * Date: 25/11/13
 * Time: 15:16
 * To change this template use File | Settings | File Templates.
 */

public class CategorieDao extends AbstractDao {
    public static List<Categorie> getAll(){
        init();

        Query query = em.createQuery("SELECT c FROM Categorie c");
        List<Categorie> categories = query.getResultList();

        destroy();
        return categories;
    }
    public static void persist(Categorie oneCategorie) {
        init();
        em.getTransaction().begin();
        if (oneCategorie.getId() != null)
            em.merge(oneCategorie);
        else
            em.persist(oneCategorie);
        em.getTransaction().commit();
        em.clear();
        destroy();
    }
    public static Categorie findOne(Long id) {
        init();

        Categorie result = em.find(Categorie.class, id);

        destroy();
        return result;
    }

    public static void insertOne(Categorie oneCategorie) {
        init();
        em.getTransaction().begin();
        em.persist(oneCategorie);
        em.getTransaction().commit();
        em.clear();
        destroy();
    }
    public static void insertOne(String name) throws Exception {

        try {
            Categorie oneCategorie = new Categorie()
                    .setName(name);
            insertOne(oneCategorie);
        } catch (Exception e) {
            throw new Exception("Internal : Can't register categorie");
        }
    }
    public static boolean isNameExist(String name) {
        init();
        Query query = em.createQuery("SELECT COUNT(c) as count FROM Categorie c WHERE c.name = :name", Long.class)
                .setParameter("name", name);
        long result = (Long) query.getSingleResult();

        destroy();
        return result > 0;
    }
}
