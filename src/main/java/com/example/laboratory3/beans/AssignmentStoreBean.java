package com.example.laboratory3.beans;

import com.example.laboratory3.entities.Assignment;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.Lock;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Startup
public class AssignmentStoreBean implements Serializable {
    @Getter
    @Setter
    private List<Assignment> assignments;

    public AssignmentStoreBean() {
        assignments = new ArrayList<>();
    }

    @Lock()
    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    public void removeAssignment(Assignment assignment) {
        assignments.remove(assignment);
    }

    @Lock()
    public boolean contains(Assignment assignment) {
        return assignments.contains(assignment);
    }
}
