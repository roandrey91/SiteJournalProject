package com.sitejournal.persistence;


import com.sitejournal.data.QuantitiesDayList;

import java.util.List;

public interface QuantitiesDAO {

    /**
     * @author Muresan Andrei
     * @param quantitiesDayList
     * Save Quantities in db.
     * */
    QuantitiesDayList saveQuantities(QuantitiesDayList quantitiesDayList);

    /**
     * @author Muresan Andrei
     * Get Quantities from db.
     * */
    List<QuantitiesDayList> getlist();

    /**
     * @author Muresan Andrei
     * @param quantitieId
     * Delete Quantities from db using id.
     * */
    void deleteQuantities(long quantitieId);

    /**
     * @author Muresan Andrei
     * @param id
     * Find Quantities in db.
     * */
    QuantitiesDayList findQuantitiesById(long id);
}
