package com.example.laboratory3.views;

import com.example.laboratory3.beans.AssignmentStoreBean;
import com.example.laboratory3.beans.DataViewBean;
import com.example.laboratory3.entities.Assignment;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class AssignmentsView extends DataViewBean<Assignment, Integer> {
    @Inject
    AssignmentStoreBean assignmentStoreBean;

    @PostConstruct
    public void init() { entities = assignmentStoreBean.getAssignments(); }

    public List<Assignment> getEntities() {
        entities = assignmentStoreBean.getAssignments();
        return entities;
    }
}
