package com.sitejournal.persistence;

import com.sitejournal.data.DaySituatiation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SituationDAOImpl implements SituationDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public DaySituatiation saveSituationDay(DaySituatiation daySituatiation) {
        if (daySituatiation.getId() == 0){
            entityManager.persist(daySituatiation);
        }else {
            entityManager.merge(daySituatiation);
        }
        return daySituatiation;
    }

    @Override
    public void deleteSituationDay(DaySituatiation daySituatiation) {
        entityManager.remove(daySituatiation);
    }

    @Override
    public List<DaySituatiation> getSituations() {
        List<DaySituatiation> situationDayList = entityManager.createQuery("SELECT a FROM DaySituatiation a",DaySituatiation.class).getResultList();
        return situationDayList;
    }
}
