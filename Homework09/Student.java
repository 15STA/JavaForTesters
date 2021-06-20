package JavaForTesters.Lesson9.Homework09;

import java.util.List;

public class Student {
    String name;
    List<Course> courses;

    public Student (String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }


}
