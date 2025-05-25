package com.example.SpringBootWithJPA.Controller;

import com.example.SpringBootWithJPA.Model.Student;
import com.example.SpringBootWithJPA.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
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
        System.out.println(studentservice.toString());
         studentservice.AddStudent(student);
        return "Successfully Added";
    }

    @GetMapping("/Students/{rno}")
    public Student GetStudentByRno(@PathVariable int rno) {
        return studentservice.GetStudentByRno(rno);
    }

}
