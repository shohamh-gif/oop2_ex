package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Department department1 = new Department("science");
        Department department2 = new Department("health");
        Department department3 = new Department("sport");

        Course c1 = new Course("qw", 3, 1, department1);
        Course c2 = new Course("as", 2, 1, department2);
        Course c3 = new Course("zx", department3);
        Course c4 = new Course("gb", department2);
        List<Course> courseList = List.of(c1, c2, c3, c4);
        List<Course> courseList2 = List.of(c2, c3, c4);


        Student s1 = new Student("a", courseList2);
        Student s2 = new Student("b", courseList);
        Student s3 = new Student("c", courseList);
        Student s4 = new Student("d", courseList);
        Student s5 = new Student("e", courseList);

        List<Student> students = List.of(s1, s2, s3, s4, s5);
        String department = "science";
        System.out.println(studentsInDepartment(students, department));
        System.out.println(topStudentsByCredits(students));
    }

    public static List<String> studentsInDepartment(List<Student> students, String departmentName) {
        return students.stream()
                .filter(student -> student.atLeastOneEqualsCourse(departmentName))
                .map(Student::getName)
                .distinct()
                .sorted()
                .toList();
    }

    public static String topStudentsByCredits(List<Student> students) {
        return students.stream()
                .max(Comparator.comparingInt(Student::countOfCredits))
                .map(Student::getName)
                .orElse(null);
    }

//    public static Map<String, List<String>> courseTitlesByDepartmentForYear(List<Student> students, int fromYear) {
//        return null;
//    }
}