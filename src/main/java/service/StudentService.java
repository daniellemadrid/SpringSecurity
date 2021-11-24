package service;

import model.Course;
import model.Student;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class StudentService {

    private static final List<Student> students = new ArrayList<>();


    // as.List  == asList é um desses métodos estáticos que obtém a matriz de entrada e retorna um objeto de java. util.
    static {
// Initialize Data
        Course course1 = new Course("Course1", "Spring", "10 Steps",
                Arrays.asList("Learn Maven", "Import Project", "First Example",
                        "Second Example"));
        Course course2 = new Course("Course2", "Spring MVC", "10 Examples",
                Arrays.asList("Learn Maven", "Import Project", "First Example",
                        "Second Example"));

        Student ranga = new Student("Student1", "Ranga Karanam",
                "Hiker, Programmer and Architect", new ArrayList<>(
                Arrays.asList(course1, course2)));

        students.add(ranga);
    }


    public Student retrieveStudent(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            } // retrieve == RECUPERAR, essa função pega o id do estudante e compara se é igual ao id do estudante e retorna o estudante
        }
        return null;
    }

    public List<Course> retrieveCourses(String studentId) {
        Student student = retrieveStudent(studentId);

        if (student == null) {
            return null;
        }
        // uma lista dos cursos que recupera os cursos contendo uma string e o id do estudante
        return student.getCourses();
    }
}

