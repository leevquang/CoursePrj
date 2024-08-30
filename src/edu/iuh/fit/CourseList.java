/*
 * @ (#) CourseList.java       1.0     Aug 30, 2024
 * Copyright (c) 2024    IUH. All rights reserved.
 */
package edu.iuh.fit;
/*
 * @description:  
 * @author: Le Van Quang
 * @date: Aug 30, 2024
 * @version: 1.0
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CourseList {
    private List<Course> courses;
    private int count;

    // Constructor
    public CourseList(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        }
        this.courses = new ArrayList<>(size);
        this.setCount(0);
    }

    // Add a course to the list
    public boolean addCourse(Course course) {
        if (exists(course.getId())) {
            System.out.println("Error: Course ID already exists.");
            return false;
        }
        courses.add(course);
        setCount(getCount() + 1);
        return true;
    }

    // Check if a course exists by ID
    private boolean exists(String id) {
        return courses.stream().anyMatch(course -> course.getId().equals(id));
    }

    // Get the list of courses
    public List<Course> getCourses() {
        return courses;
    }

    // Remove a course by ID
    public boolean removeCourse(String id) {
        Course course = searchCourseById(id);
        if (course != null) {
            courses.remove(course);
            setCount(getCount() - 1);
            return true;
        }
        System.out.println("Error: Course ID not found.");
        return false;
    }

    // Search a course by ID
    public Course searchCourseById(String id) {
        return courses.stream().filter(course -> course.getId().equals(id)).findFirst().orElse(null);
    }

    // Search courses by title (relative search)
    public List<Course> searchCoursesByTitle(String title) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.getTitle().contains(title)) {
                result.add(course);
            }
        }
        return result.isEmpty() ? null : result;
    }

    // Search courses by department
    public List<Course> searchCoursesByDepartment(String department) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.getDepartment().equalsIgnoreCase(department)) {
                result.add(course);
            }
        }
        return result.isEmpty() ? null : result;
    }

    // Sort courses by title
    public List<Course> sortCourses() {
        List<Course> sortedCourses = new ArrayList<>(courses);
        sortedCourses.sort(Comparator.comparing(Course::getTitle));
        return sortedCourses;
    }

    // Find courses with maximum credit
    public List<Course> findMaxCreditCourses() {
        int maxCredit = courses.stream().max(Comparator.comparingInt(Course::getCredit)).get().getCredit();
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.getCredit() == maxCredit) {
                result.add(course);
            }
        }
        return result;
    }

    // Find department with most courses
    public String findDepartmentWithMostCourses() {
        return courses.stream().map(Course::getDepartment)
                .reduce((dept1, dept2) -> courses.stream().filter(course -> course.getDepartment().equals(dept1)).count() >
                        courses.stream().filter(course -> course.getDepartment().equals(dept2)).count() ? dept1 : dept2)
                .orElse(null);
    }

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
