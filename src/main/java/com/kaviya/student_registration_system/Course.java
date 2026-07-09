package com.kaviya.student_registration_system;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {
    @Id
    private Integer id;
    private String courseName;
    private String duration;
    private double fees;

    public Course()
    {

    }

    public Course(Integer id, String courseName, String duration, double fees) {
        this.id = id;
        this.courseName = courseName;
        this.duration = duration;
        this.fees = fees;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public double getFees() {
        return fees;
    }
    public void setFees(double fees) {
        this.fees = fees;
    }
    
}
