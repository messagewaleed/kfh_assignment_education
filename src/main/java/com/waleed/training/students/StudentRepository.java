package com.waleed.training.students;

import com.waleed.training.courses.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository  extends CrudRepository<Student, Integer> {
    List<Student> findByCourseId(Integer id);
   }
