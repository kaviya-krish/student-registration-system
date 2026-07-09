package com.kaviya.student_registration_system;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
public class User {

    @Id
    private Integer id;
    @NotBlank(message = "Name is required")
    private String name;
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;
    @Size(min = 6, message = "Password should have at least 6 characters")
    private String password;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public User() {
    }

    public User(Integer id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}