package com.waleed.training.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository repo;

    public List<Student> getAllStudentsByCourseId(Integer courseId){
        return repo.findByCourseId(courseId);
    }

    public void addNewStudent(Student student) {
        repo.save(student);
    }

        public void updateStudent(Student student){
            repo.save(student);
        }

        public void deleteStudent(Integer studentId){
            repo.deleteById(studentId);
        }
}
