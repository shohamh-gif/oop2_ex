package org.example;

import java.util.List;

public class Student implements Comparable<Student> {
    private String name;
    private List<Course> courses;

    public Student(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public int countOfCredits() {
        if (this.courses == null || this.courses.size() <= 0) {
            return 0;
        }
        return this.courses
                .stream()
                .mapToInt(Course::getCredits)
                .sum();
    }

    public boolean atLeastOneEqualsCourse(String department) {
        return this.courses.stream()
                .anyMatch(course -> course.getDepartment().getName().equals(department));
    }

    @Override
    public int compareTo(Student other) {
        return this.countOfCredits() - other.countOfCredits();
    }
}
