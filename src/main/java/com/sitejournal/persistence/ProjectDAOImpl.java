package com.sitejournal.persistence;

import com.sitejournal.data.ProjectDetails;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ProjectDetails setProject(ProjectDetails projectDetails) {
        if (projectDetails.getId() == 0){
            entityManager.persist(projectDetails);
        }else {
            entityManager.merge(projectDetails);
        }
        return projectDetails;
    }

    @Override
    public ProjectDetails edtiProject(ProjectDetails projectDetails) {
        return entityManager.merge(projectDetails);
    }

}
