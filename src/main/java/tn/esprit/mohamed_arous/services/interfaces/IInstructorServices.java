package tn.esprit.mohamed_arous.services.interfaces;

import tn.esprit.mohamed_arous.entities.Instructor;
import tn.esprit.mohamed_arous.entities.Support;

import java.util.List;

public interface IInstructorServices {
    List<Instructor> retrieveAllInstructors();
    Instructor addInstructor(Instructor instructor);
    Instructor updateInstructor(Instructor instructor);
    Instructor retrieveInstructor(long numInstructor);
    void deleteInstructor(long numInstructor);
    Instructor addInstructorAndAssignToCourse(Instructor instructor, Long numCourse);
    List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support);
}
