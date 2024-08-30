/*
 * @ (#) TestCourse.java       1.0     Aug 30, 2024
 * Copyright (c) 2024    IUH. All rights reserved.
 */
package edu.iuh.fit;
/*
 * @PHULUC:  Tham Khao ChatGPT
 * @author: Le Van Quang
 * @date: Aug 30, 2024
 * @version: 1.0
 */
import java.util.List;
import java.util.Scanner;

public class TestCourse {

    public static void main(String[] args) {
        CourseList courseList = new CourseList(10);
        initData(courseList);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Course Management Menu ---");
            System.out.println("1. Add Course");
            System.out.println("2. View Courses");
            System.out.println("3. Remove Course");
            System.out.println("4. Search Course by ID");
            System.out.println("5. Search Courses by Title");
            System.out.println("6. Search Courses by Department");
            System.out.println("7. Sort Courses by Title");
            System.out.println("8. Find Courses with Max Credit");
            System.out.println("9. Find Department with Most Courses");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addCourse(courseList, scanner);
                    break;
                case 2:
                    viewCourses(courseList);
                    break;
                case 3:
                    removeCourse(courseList, scanner);
                    break;
                case 4:
                    searchCourseById(courseList, scanner);
                    break;
                case 5:
                    searchCoursesByTitle(courseList, scanner);
                    break;
                case 6:
                    searchCoursesByDepartment(courseList, scanner);
                    break;
                case 7:
                    sortCourses(courseList);
                    break;
                case 8:
                    findMaxCreditCourses(courseList);
                    break;
                case 9:
                    findDepartmentWithMostCourses(courseList);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void initData(CourseList courseList) {
        courseList.addCourse(new Course("4203014062", "GiaiThuatVaPhanTan", 3, "CNTT"));
        courseList.addCourse(new Course("4203014063", "TrucQuanHoaDuLieu", 4, "KHDL"));
        courseList.addCourse(new Course("4203014064", "DaisoTuyenTinh", 4, "CNTT"));
        courseList.addCourse(new Course("4203014106", "QuaTrinhNgauNhien", 3, "KHMT"));
    }

    private static void addCourse(CourseList courseList, Scanner scanner) {
        System.out.print("Enter Course ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Course Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Course Credit: ");
        int credit = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        Course course = new Course(id, title, credit, department);
        courseList.addCourse(course);
    }

    private static void viewCourses(CourseList courseList) {
        List<Course> courses = courseList.getCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            System.out.println("\n--- List of Courses ---");
            for (Course course : courses) {
                System.out.println(course);
            }
        }
    }

    private static void removeCourse(CourseList courseList, Scanner scanner) {
        System.out.print("Enter Course ID to remove: ");
        String id = scanner.nextLine();
        if (courseList.removeCourse(id)) {
            System.out.println("Course removed successfully.");
        }
    }

    private static void searchCourseById(CourseList courseList, Scanner scanner) {
        System.out.print("Enter Course ID to search: ");
        String id = scanner.nextLine();
        Course course = courseList.searchCourseById(id);
        if (course != null) {
            System.out.println(course);
        } else {
            System.out.println("Course not found.");
        }
    }

    private static void searchCoursesByTitle(CourseList courseList, Scanner scanner) {
        System.out.print("Enter Course Title to search: ");
        String title = scanner.nextLine();
        List<Course> courses = courseList.searchCoursesByTitle(title);
        if (courses != null && !courses.isEmpty()) {
            for (Course course : courses) {
                System.out.println(course);
            }
        } else {
            System.out.println("No courses found with the given title.");
        }
    }

    private static void searchCoursesByDepartment(CourseList courseList, Scanner scanner) {
        System.out.print("Enter Department to search: ");
        String department = scanner.nextLine();
        List<Course> courses = courseList.searchCoursesByDepartment(department);
        if (courses != null && !courses.isEmpty()) {
            for (Course course : courses) {
                System.out.println(course);
            }
        } else {
            System.out.println("No courses found for the given department.");
        }
    }

    private static void sortCourses(CourseList courseList) {
        List<Course> sortedCourses = courseList.sortCourses();
        System.out.println("\n--- Sorted List of Courses ---");
        for (Course course : sortedCourses) {
            System.out.println(course);
        }
    }

    private static void findMaxCreditCourses(CourseList courseList) {
        List<Course> maxCreditCourses = courseList.findMaxCreditCourses();
        System.out.println("\n--- Courses with Max Credit ---");
        for (Course course : maxCreditCourses) {
            System.out.println(course);
        }
    }

    private static void findDepartmentWithMostCourses(CourseList courseList) {
        String department = courseList.findDepartmentWithMostCourses();
        System.out.println("Department with most courses: " + department);
    }
}
