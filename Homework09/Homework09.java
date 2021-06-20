package JavaForTesters.Lesson9.Homework09;


import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Homework09 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student("Petrov", Arrays.asList(new Course("Programming"),
                new Course("Testing"), new Course("Data engineering"))),
                new Student("Ivanova", Arrays.asList(new Course("Design"),
                        new Course("Management"))),
                new Student("Sidorov", Arrays.asList(new Course("Programming"),
                        new Course("Analitics"))),
                new Student("Dmitriev", Arrays.asList(new Course("Programming"),
                        new Course("Analitics"), new Course("Web design"), new Course("Testing"))));
        Course course = new Course("Testing");


        System.out.println("Task1");
        func1(students);
        System.out.println("------------------------");
        System.out.println("Task2");
        func2(students);
        System.out.println("------------------------");
        System.out.println("Task3");
        func3(students, course);
    }

/*
Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты.
 */

    public static void func1(List<Student> students) {
        Function<List<Student>, Set<Course>> function1 = new Function<List<Student>, Set<Course>>() {
            @Override
            public Set<Course> apply(List<Student> students) {
                return students.stream()
                        .map(student -> student.getCourses())
                        .flatMap(st -> st.stream())
                        .collect(Collectors.toSet());
            }
        };
        System.out.println(function1.apply(students));
    }

    /*
    Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных (любознательность определяется количеством курсов).
    */

    public static void func2(List<Student> students) {
        Function<List<Student>, List<Student>> function2 = new Function<List<Student>, List<Student>>() {
            @Override
            public List<Student> apply(List<Student> students) {
                return students.stream()
                        .sorted((st1, st2) -> st2.getCourses().size() - st1.getCourses().size())
                        .limit(3)
                        .collect(Collectors.toList());

            }
        };
        System.out.println(function2.apply(students));
    }

     /*
    Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов, которые посещают этот курс.
     */

    public static void func3(List<Student> students, Course course) {
        System.out.println(students.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList()));

    }

}
