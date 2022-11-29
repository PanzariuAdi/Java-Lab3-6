package com.example.laboratory3.beans;

import com.example.laboratory3.entities.Assignment;

import javax.ejb.Stateful;
import javax.inject.Inject;
import java.io.Serializable;

@Stateful
public class AssignmentManagerBean implements Serializable {
    @Inject
    AssignmentStoreBean assignmentStoreBean;
    @Inject
    AssignmentCheckBean assignmentCheckBean;

    public void addAssignment(Assignment assignment) {
        if (assignmentCheckBean.isAvailable(assignment)) {
            assignmentStoreBean.addAssignment(assignment);
        }
    }
}
