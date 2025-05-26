package com.example.SpringBootWithJPA.Services;

import com.example.SpringBootWithJPA.Model.Student;
import com.example.SpringBootWithJPA.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentrepository;

    public List<Student> getAllStudents() {
        return studentrepository.findAll();
    }

    public void AddStudent(Student student) {
         studentrepository.save(student);
    }

    public Student GetStudentByRno(int rno) {
         return studentrepository.findById(rno).orElse(new Student());
    }

    public void Editstudent(Student student) {
        studentrepository.save(student);
    }

    public void DeleteStudent(int rno) {
        studentrepository.deleteById(rno);
    }

    public void clearStudents() {
        studentrepository.deleteAll();
    }

    public List<Student> getStudentByTechnology(String tech) {
        return studentrepository.getStudentsByTechnology(tech);
    }

    public List<Student> getByGenderAndTechnology(String gender, String technology) {
        return studentrepository.getByGenderAndTechnology(gender,technology);
    }
}
