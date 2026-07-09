package com.kaviya.student_registration_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {

    User existingUser = userRepository.findByEmail(user.getEmail());

    if (existingUser != null) {
        return "User already registered";
    }

    user.setPassword(passwordEncoder.encode(user.getPassword()));

    userRepository.save(user);

    return "Registration Successful";
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

    User existingUser = userRepository.findByEmail(user.getEmail());

    if (existingUser != null &&
        passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {

        return ResponseEntity.ok(existingUser);

    } else {

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Invalid Email or Password");
    }
    }

    @PutMapping("/users/{userId}/course/{courseId}")
    public String registerCourse(@PathVariable Integer userId,
                             @PathVariable Integer courseId) {

    User user = userRepository.findById(userId).orElse(null);

    Course course = courseRepository.findById(courseId).orElse(null);

    if (user == null || course == null) {
        return "User or Course not found";
    }

    user.setCourse(course);
    userRepository.save(user);

    return "Course Registered Successfully";
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {

    User existingUser = userRepository.findById(id).orElse(null);

    if (existingUser == null) {
        return null;
    }

    existingUser.setName(updatedUser.getName());
    existingUser.setEmail(updatedUser.getEmail());
    existingUser.setPassword(updatedUser.getPassword());

    return userRepository.save(existingUser);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Integer id) {

    if (userRepository.existsById(id)) {
        userRepository.deleteById(id);
        return "User Deleted Successfully";
    } else {
        return "User Not Found";
    }
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id) {

    return userRepository.findById(id).orElse(null);

    }

    @GetMapping("/dashboard/{id}")
    public User getDashboard(@PathVariable Integer id) {

    return userRepository.findById(id).orElse(null);

    }
    @GetMapping("/users/email/{email}")
    public User getUserByEmail(@PathVariable String email) {

    return userRepository.findByEmail(email);

   }
   @GetMapping("/test")
   public String testException() {
    throw new RuntimeException("This is a test exception");
    }
    

}