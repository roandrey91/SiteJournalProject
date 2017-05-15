package com.sitejournal.persistence;


import com.sitejournal.data.ProjectDetails;

public interface ProjectDAO {

    /**
     * @author Muresan Andrei
     * @param projectDetails
     * Save Project details in db.
     * */
    ProjectDetails setProject(ProjectDetails projectDetails);

    /**
     * @author Muresan Andrei
     * @param projectDetails
     * Save Project details in db.
     * */
    ProjectDetails edtiProject(ProjectDetails projectDetails);

}
