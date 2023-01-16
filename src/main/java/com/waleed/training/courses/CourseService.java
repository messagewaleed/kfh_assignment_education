package com.waleed.training.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository repo;

    List<Course> getAllCourses(){
        return (List<Course>)repo.findAll();
    }

    @Cacheable("courses")
    Optional<Course> getCourseDetailsById(@PathVariable Integer id){
        return repo.findById(id);
    }
    

//    List<Course> findCoursesByLocation(String location){
//        return repo.findByLocation(location);
//    }
//
//    List<Course> findCoursesByName(String name){
//        return repo.findByName(name);
//    }

    void addNewCourse(@RequestBody Course user){
        repo.save(user);
    }

    void updateCourseDetailsById(@PathVariable Integer id, @RequestBody Course user){
        repo.save(user);
    }

    void deleteCourseDetailsById(@PathVariable Integer id){
        repo.deleteById(id);
    }
}
