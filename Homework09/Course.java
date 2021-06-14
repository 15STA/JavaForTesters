package JavaForTesters.Lesson9.Homework09;

import java.util.Objects;

public class Course {
        String nameOfCourse;
        public Course(String nameOfCourse) {
            this.nameOfCourse = nameOfCourse;
        }

    @Override
    public String toString() {
        return "nameOfCourse=" + nameOfCourse;
    }

    public String getNameOfCourse() {
        return nameOfCourse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return getNameOfCourse().equals(course.getNameOfCourse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameOfCourse());
    }
}
