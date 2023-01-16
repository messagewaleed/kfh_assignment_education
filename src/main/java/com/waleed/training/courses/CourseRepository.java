package com.waleed.training.courses;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {


//    List<Course> findByLocation(String location);
//    List<Course> findByName(String name);
}
