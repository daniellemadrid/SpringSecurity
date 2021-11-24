package controller;

import model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import service.StudentService;

import java.util.List;

@RestController
public class StudentController {

    @Autowired // não precisa estanciar uma classe
    private StudentService studentService;

    @GetMapping("/students/{studentId}/courses") // Anotação para mapeamento de solicitações HTTP GET em métodos específicos do manipulador .


    public List<Course> retrieveCoursesForStudent(@PathVariable String studentId) {
        return studentService.retrieveCourses(studentId);
        //lista cde curso que recupera os cursos para o estudante com um id
    }
}
