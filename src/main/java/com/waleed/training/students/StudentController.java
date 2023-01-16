package com.waleed.training.students;

import com.waleed.training.courses.Course;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("Student Controller")
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping("/students/courses/{courseId}")
    @ApiOperation(value = "Get all Students for a course", notes = "Hit this endpoint to fetch all students for a particular course")
    List<Student> getAllStudentsByCourseId(@PathVariable Integer courseId){
        return service.getAllStudentsByCourseId(courseId);
    }

    @PostMapping("/students/courses/{courseId}")
    @ApiOperation(value = "Add a new Student for a course", notes = "Hit this endpoint to add a new Student for a particular course")
    void addNewStudent(@RequestBody Student student, @PathVariable Integer courseId){
        student.setCourse(new Course(courseId, "", ""));
        service.addNewStudent(student);
    }

    @PutMapping("/students/courses/{courseId}")
    @ApiOperation(value = "Update Student", notes = "Hit this endpoint to update a Student by Course")
    void updateStudent(@RequestBody Student student, @PathVariable Integer courseId){
        student.setCourse(new Course(courseId, "", ""));
        service.updateStudent(student);
    }

    @DeleteMapping("/students/{studentId}")
    @ApiOperation(value = "Delete a Student", notes = "Hit this endpoint to delete a Student by his/her id")
    void deleteStudent(@PathVariable Integer studentId){
        service.deleteStudent(studentId);
    }

}
