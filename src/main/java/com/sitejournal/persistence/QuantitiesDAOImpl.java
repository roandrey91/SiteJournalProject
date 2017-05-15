package com.sitejournal.persistence;


import com.sitejournal.data.QuantitiesDayList;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class QuantitiesDAOImpl implements QuantitiesDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public QuantitiesDayList saveQuantities(QuantitiesDayList quantitiesDayList) {
        if (quantitiesDayList.getId() == 0) {
            entityManager.persist(quantitiesDayList);
        } else {
            entityManager.merge(quantitiesDayList);
        }
        return quantitiesDayList;
    }

    @Override
    public List<QuantitiesDayList> getlist() {
        List<QuantitiesDayList> getQ = entityManager.createQuery("SELECT a FROM QuantitiesDayList a",QuantitiesDayList.class).getResultList();
        return getQ;
    }

    @Override
    public void deleteQuantities(long quantitieId) {
    QuantitiesDayList findQ = findQuantitiesById(quantitieId);
    entityManager.remove(findQ);
    }

    @Override
    public QuantitiesDayList findQuantitiesById(long id) {
        return entityManager.find(QuantitiesDayList.class, id);
    }
}
