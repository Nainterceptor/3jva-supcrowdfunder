package com.supinfo.supcrowdfunder.dao;

import com.supinfo.supcrowdfunder.entity.Contribute;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
* Created with IntelliJ IDEA.
* User: Robin
* Date: 26/11/13
* Time: 15:34
* To change this template use File | Settings | File Templates.
*/
public class ContributeDao extends AbstractDao {
    public static List<Contribute> getAll() {
        init();

        Query query = em.createQuery("SELECT p FROM Contribute p");
        List<Contribute> contributes = query.getResultList();

        destroy();
        return contributes;
    }

    public static void insertOne(Contribute oneContribute) {
        init();
        em.getTransaction().begin();
        em.persist(oneContribute);
        em.getTransaction().commit();
        em.clear();
        destroy();
    }

    public static void insertOne(Long amount, Long userId, java.sql.Date rightNow) throws Exception {

        try {
            Contribute oneContribute = new Contribute()
                    .setAmount(amount)
                    .setUserId(userId)
                    .setRightNow(rightNow);
            insertOne(oneContribute);
        } catch (Exception e) {
            throw new Exception("Internal : Can't create project");
        }
    }
}

