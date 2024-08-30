/*
 * @ (#) Course.java       1.0     Aug 30, 2024
 * Copyright (c) 2024    IUH. All rights reserved.
 */
package edu.iuh.fit;
/*
 * @description:  
 * @author: Le Van Quang
 * @date: Aug 30, 2024
 * @version: 1.0
 */
public class Course {
    private String id;
    private String title;
    private int credit;
    private String department;

    // Constructors
    public Course() {}

    public Course(String id, String title, int credit, String department) {
        setId(id);
        setTitle(title);
        setCredit(credit);
        setDepartment(department);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCredit() {
        return credit;
    }

    public String getDepartment() {
        return department;
    }

    // Setters
    public void setId(String id) {
        if (id == null || id.length() < 3 || !id.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("ID must have at least 3 characters and contain only letters or digits");
        }
        this.id = id;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
        this.title = title;
    }

    public void setCredit(int credit) {
        if (credit <= 0) {
            throw new IllegalArgumentException("Credit must be greater than 0");
        }
        this.credit = credit;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("Course ID: %s, Title: %s, Credit: %d, Department: %s", id, title, credit, department);
    }
}
