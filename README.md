# 🎓 Student Registration System

A Full Stack Student Registration System developed using Spring Boot, MySQL, HTML, CSS, and JavaScript.

## 📌 Features

- User Registration
- Secure Login
- BCrypt Password Encryption
- Duplicate Email Validation
- Course Management
- Course Registration
- Dashboard
- Input Validation
- REST APIs
- MySQL Database Integration

## 🛠️ Technologies Used

### Backend
- Java 24
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven

### Frontend
- HTML5
- CSS3
- JavaScript

## 📂 Project Structure

```
src
 ├── main
 │   ├── java
 │   ├── resources
 │   │    ├── static
 │   │    ├── templates
 │   │    └── application.properties
 │   └── test
```

## Database

Database Name

```
student_db
```

Tables

- user
- course

## API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | /signup | Register User |
| POST | /login | User Login |
| GET | /dashboard/{id} | User Dashboard |
| GET | /courses | View Courses |
| POST | /courses | Add Course |
| PUT | /users/{userId}/course/{courseId} | Register Course |

## Security

- BCrypt Password Encryption
- Input Validation
- Duplicate Email Check

## Future Enhancements

- JWT Authentication
- Admin Dashboard
- Email Verification
- Forgot Password
- Profile Update
- Responsive UI Improvements

## Author

**Kaviya N**

GitHub: https://github.com/student-registration-system/

