package com.sitejournal.services;

import com.sitejournal.data.ProjectDetails;
import com.sitejournal.persistence.ProjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectService{

    @Autowired
    private ProjectDAO projectDAO;

    @Transactional
    public ProjectDetails setProject(ProjectDetails projectDetails){
      return projectDAO.setProject(projectDetails);
    }

    @Transactional
    public ProjectDetails edtiProject(ProjectDetails projectDetails){
        return projectDAO.edtiProject(projectDetails);
    }

}
