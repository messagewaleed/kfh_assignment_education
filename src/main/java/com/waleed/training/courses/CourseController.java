package com.waleed.training.courses;

import com.waleed.training.CourseClient;
import com.waleed.training.exceptions.CourseNotFoundException;
import com.waleed.training.wsdl.GetCourseRequest;
import com.waleed.training.wsdl.GetCourseResponse;
import com.waleed.training.wsdl.ObjectFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Course Controller")
public class CourseController {

    @Autowired
    CourseClient courseClient;

    @Autowired
    CourseService service;

    @GetMapping(value = "/courses")
    @ApiOperation(value = "Get all Courses", notes = "Hit this endpoint to fetch all Courses")
    List<Course> getAllCourses() {
        return service.getAllCourses();
    }

    @GetMapping("/courses/{id}")
    @ApiOperation(value = "Get one Course details by id", notes = "Hit this endpoint to fetch a Course by id", response = Course.class)
    Optional<Course> getCourseDetailsById(@PathVariable Integer id) {
       return Optional.ofNullable(service.getCourseDetailsById(id).orElseThrow(() -> new CourseNotFoundException()));
    }


//    Find courses by location
//    @GetMapping("/courses/location/{location}")
//    List<Course> findCoursesByLocation(@PathVariable String location){
//        return service.findCoursesByLocation(location);
//    }
//
//    //    Find courses by name
//    @GetMapping("/courses/name/{name}")
//    List<Course> findCoursesByName(@PathVariable String name){
//        return service.findCoursesByName(name);
//    }

    @PostMapping("/courses")
    @ApiOperation(value = "Add a new Course", notes = "Hit this endpoint to add a new Course")
    void addNewCourse(@RequestBody Course course) {
        service.addNewCourse(course);
    }

    @PutMapping("/courses/{id}")
    @ApiOperation(value = "update a Course", notes = "Hit this endpoint to update an already existing Course")
    void updateCourseDetailsById(@PathVariable Integer id, @RequestBody Course course) {
        service.updateCourseDetailsById(id, course);
    }

    @DeleteMapping("/courses/{id}")
    @ApiOperation(value = "Delete a Course", notes = "Hit this endpoint to delete an existing Course")
    void deleteCourseDetailsById(@PathVariable Integer id) {
        service.deleteCourseDetailsById(id);
    }

    @GetMapping("/courses/soap")
    public List<com.waleed.training.wsdl.Course> getCourses() {
        ObjectFactory objectFactory = new ObjectFactory();

        GetCourseRequest request = new GetCourseRequest();
        request.setName("java");

        GetCourseResponse response = courseClient.getCourses();

        return response.getCourses();
    }

}
