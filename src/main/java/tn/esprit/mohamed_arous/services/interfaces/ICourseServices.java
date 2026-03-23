package tn.esprit.mohamed_arous.services.interfaces;

import org.springframework.context.annotation.Bean;
import tn.esprit.mohamed_arous.entities.Course;

import java.util.List;

public interface ICourseServices {
    List<Course> retrieveAllCourses();
    Course addCourse(Course c);
    Course updateCourse(Course c);
    Course retrieveCourse(long numC);
    void deleteCourse(long numC);
}
