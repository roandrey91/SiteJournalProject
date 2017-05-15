package com.sitejournal.persistence;

import com.sitejournal.data.DaySituatiation;

import java.util.List;

public interface SituationDAO  {

    /**
     * @author Muresan Andrei
     * @param daySituatiation
     * Save Situations in db.
     * */
    DaySituatiation saveSituationDay (DaySituatiation daySituatiation);

    /**
     * @author Muresan Andrei
     * @param daySituatiation
     * Delete Situations from db.
     * */
    void deleteSituationDay(DaySituatiation daySituatiation);

    /**
     * @author Muresan Andrei
     * Get all Situations from db.
     * */
    List<DaySituatiation> getSituations();


}
