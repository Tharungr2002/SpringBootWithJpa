package com.example.SpringBootWithJPA.Controller;

import com.example.SpringBootWithJPA.Model.Student;
import com.example.SpringBootWithJPA.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Student> GetStudentByRno(@PathVariable int rno) {
        Student student = studentservice.GetStudentByRno(rno);
        if(student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @PutMapping("/Students")
    public String EditStudent(@RequestBody Student student) {
        studentservice.Editstudent(student);
        return "Succesfully Updated";
    }

    @DeleteMapping("/Students/{rno}")
    public ResponseEntity<String>  DeleteStudent(@PathVariable int rno) {
        try{
            studentservice.DeleteStudent(rno);
            return new ResponseEntity<>("Successfully cleared all students",HttpStatus.OK);
        }catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @DeleteMapping("/ClearStudents")
    public String clearStudents() {
        studentservice.clearStudents();
        return "Successfully student deletdd";
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
