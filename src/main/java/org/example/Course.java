package org.example;


public class Course {
    private String title;
    private int credits;
    private int year;
    private Department department;

    public Course(String title, int credits, int year, Department department) {
        this.title = title;
        this.credits = credits;
        this.year = year;
        this.department = department;
    }

    public Course(String title, Department department) {
        this.title = title;
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getDepartmentName() {
        return this.department.getName();
    }

    public boolean isYearBigger(int fromYear) {
        return this.year >= fromYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return this.title.equals(course.title);
    }

    @Override
    public int hashCode() {
        return this.title.hashCode();
    }
}