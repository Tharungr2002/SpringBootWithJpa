package com.example.SpringBootWithJPA.Repository;

import com.example.SpringBootWithJPA.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository <Student,Integer>{


    List<Student> getStudentsByTechnology(String tech);

    //Native Query...it can be also done by jpa just for practice....
    @Query(nativeQuery = true,
            value = "SELECT * FROM student WHERE gender =:gender AND technology =:technology")
    List<Student> getByGenderAndTechnology(@Param("gender") String gender,
                                           @Param("technology") String technology);
}
