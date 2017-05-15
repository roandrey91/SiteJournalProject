package com.sitejournal.services;


import com.sitejournal.data.DaySituatiation;
import com.sitejournal.persistence.SituationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SituationService {

    @Autowired
    private SituationDAO situationDAO;


    @Transactional
    public DaySituatiation saveSituationDay (DaySituatiation situationDay){
        return situationDAO.saveSituationDay(situationDay);
    }
    @Transactional
    public void deleteSituationDay(DaySituatiation situationDay){
        situationDAO.deleteSituationDay(situationDay);
    }

    @Transactional
    public List<DaySituatiation> getSituations(){
        return situationDAO.getSituations();
    }

}
