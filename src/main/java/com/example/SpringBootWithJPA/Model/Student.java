package com.example.SpringBootWithJPA.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Student {
    @Id
    private int rno;
    private String name;
    private String technology;
    private String gender;

    public Student(int rno, String name, String technology, String gender) {
        this.rno = rno;
        this.name = name;
        this.technology = technology;
        this.gender = gender;
    }

    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rno=" + rno +
                ", name='" + name + '\'' +
                ", technology='" + technology + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public Student() {

    }
}
