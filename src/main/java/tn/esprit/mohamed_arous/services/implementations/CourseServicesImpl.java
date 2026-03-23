package tn.esprit.mohamed_arous.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.mohamed_arous.entities.Course;
import tn.esprit.mohamed_arous.repositories.ICourseRepository;
import tn.esprit.mohamed_arous.services.interfaces.ICourseServices;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseServicesImpl implements ICourseServices{
    ICourseRepository courseRepository;

    @Override
    public List<Course> retrieveAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course retrieveCourse(long numCourse) {
        return courseRepository.findById(numCourse).orElse(null);
    }

    @Override
    public void deleteCourse(long numCourse) {
        courseRepository.deleteById(numCourse);
    }
}
