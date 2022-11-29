package com.example.laboratory3.beans;

import com.example.laboratory3.entities.Assignment;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AssignmentCheckBean {
    @Inject
    AssignmentStoreBean assignmentStoreBean;

    public boolean isAvailable(Assignment assignment) {
        return !assignmentStoreBean.contains(assignment);
    }
}
