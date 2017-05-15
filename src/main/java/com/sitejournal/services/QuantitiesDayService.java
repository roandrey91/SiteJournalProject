package com.sitejournal.services;

import com.sitejournal.data.QuantitiesDayList;
import com.sitejournal.persistence.QuantitiesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuantitiesDayService {

    @Autowired
    private QuantitiesDAO quantitiesListDAO;

    @Transactional
    public QuantitiesDayList saveQuantities(QuantitiesDayList quantitiesDayList) {
        return quantitiesListDAO.saveQuantities(quantitiesDayList);
    }

    @Transactional
    public List<QuantitiesDayList> getlist() {
        return quantitiesListDAO.getlist();
    }

    @Transactional
    public void deleteQuantities(long quantitieId){
        quantitiesListDAO.deleteQuantities(quantitieId);
    }

    @Transactional
    public QuantitiesDayList findQuantitiesById(long id){
        return quantitiesListDAO.findQuantitiesById(id);
    }
}
