package com.example.SpringBootWithJPA.Controller;

import com.example.SpringBootWithJPA.Model.Student;
import com.example.SpringBootWithJPA.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentservice;

    @GetMapping("/Students")
    public List<Student> GetAllStudents() {
        return studentservice.getAllStudents();
    }

    @PostMapping("/Students")
    public String AddStudent(@RequestBody Student student) {
        System.out.println(student);
         studentservice.AddStudent(student);
        return "Successfully Added";
    }

    @GetMapping("/Students/{rno}")
    public Student GetStudentByRno(@PathVariable int rno) {
        return studentservice.GetStudentByRno(rno);
    }

    @PutMapping("/Students")
    public String EditStudent(@RequestBody Student student) {
        studentservice.Editstudent(student);
        return "Succesfully Updated";
    }

    @DeleteMapping("/Students/{rno}")
    public String DeleteStudent(@PathVariable int rno) {
        studentservice.DeleteStudent(rno);
        return "Successfully student deletdd";
    }

    @DeleteMapping("/ClearStudents")
    public String clearStudents() {
        studentservice.clearStudents();
        return "Successfully cleared all students";
    }

    @GetMapping("/Students/technology/{tech}")
    public List<Student> getStudentByTechnology(@PathVariable String tech) {
        return studentservice.getStudentByTechnology(tech);
    }

    @GetMapping("/Students/filter")
    public List<Student> getByGenderAndTechnology(@Param("gender") String gender,
                                                  @Param("technology") String technology) {
        return studentservice.getByGenderAndTechnology(gender,technology);
    }
}
