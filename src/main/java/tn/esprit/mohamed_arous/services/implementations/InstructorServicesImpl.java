package tn.esprit.mohamed_arous.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.mohamed_arous.entities.Course;
import tn.esprit.mohamed_arous.entities.Instructor;
import tn.esprit.mohamed_arous.entities.Registration;
import tn.esprit.mohamed_arous.entities.Support;
import tn.esprit.mohamed_arous.repositories.ICourseRepository;
import tn.esprit.mohamed_arous.repositories.IInstructorRepository;
import tn.esprit.mohamed_arous.services.interfaces.IInstructorServices;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class InstructorServicesImpl implements IInstructorServices {
    IInstructorRepository instructorRepository;
    ICourseRepository courseRepository;

    @Override
    public List<Instructor> retrieveAllInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor retrieveInstructor(long numInstructor) {
        return instructorRepository.findById(numInstructor).orElse(null);
    }

    @Override
    public void deleteInstructor(long numInstructor) {
        instructorRepository.deleteById(numInstructor);
    }

    @Override
    public Instructor addInstructorAndAssignToCourse(Instructor instructor, Long numCourse) {
        Course course = courseRepository.findById(numCourse).orElseThrow(() -> new RuntimeException("Course not found"));
        instructor.getCourses().add(course);
        return instructorRepository.save(instructor);
    }

    @Override
    public List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support) {
        Instructor instructor = instructorRepository.findById(numInstructor).orElseThrow(() -> new RuntimeException("Instructor not found"));
        List<Integer> numWeeks = new ArrayList<>();
        for (Course course : instructor.getCourses()) {
            if (course.getSupport() == support) {
                for (Registration reg : course.getRegistrations()) {
                    numWeeks.add(reg.getNumWeek());
                }
            }
        }
        return numWeeks;
    }
}
