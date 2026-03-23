package tn.esprit.mohamed_arous.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.mohamed_arous.entities.Course;
import tn.esprit.mohamed_arous.services.interfaces.ICourseServices;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final ICourseServices courseService;

    public CourseController(ICourseServices courseservices) {
        this.courseService = courseservices;
    }

    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @GetMapping("/retrieve/{numCourse}")
    public Course retrieveCourse(@PathVariable long numCourse) {
        return courseService.retrieveCourse(numCourse);
    }


    @PutMapping("/update")
    public Course updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/remove/{numCourse}")
    public void deleteCourse(@PathVariable("numCourse") Long numCourse) {
        courseService.deleteCourse(numCourse);
    }

    @GetMapping("/retrieve-all")
    public List<Course> retrieveAllCourses() {
        return courseService.retrieveAllCourses();
    }
}