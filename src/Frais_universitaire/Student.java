package Frais_universitaire;

import javax.swing.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private final int id;
    private final String firstName;
    private final String lastName;
    private Instant entryDate;
    private final List<GroupLayout.Group> groupHistory = new ArrayList<>();

    public Student(int id, String firstName, String lastName, Instant entryDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.entryDate = entryDate;
    }

    public void addGroup(GroupLayout.Group g) {
        groupHistory.add(g);
    }

    public List<GroupLayout.Group> getGroupHistory() {
        return groupHistory;
    }

    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
}

