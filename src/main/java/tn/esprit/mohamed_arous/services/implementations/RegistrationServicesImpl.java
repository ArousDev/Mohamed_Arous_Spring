package tn.esprit.mohamed_arous.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.mohamed_arous.entities.Course;
import tn.esprit.mohamed_arous.entities.Registration;
import tn.esprit.mohamed_arous.entities.Skier;
import tn.esprit.mohamed_arous.entities.TypeCourse;
import tn.esprit.mohamed_arous.repositories.ICourseRepository;
import tn.esprit.mohamed_arous.repositories.IRegistrationRepository;
import tn.esprit.mohamed_arous.repositories.ISkierRepository;
import tn.esprit.mohamed_arous.services.interfaces.IRegistrationServices;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@AllArgsConstructor
public class RegistrationServicesImpl implements IRegistrationServices {
    IRegistrationRepository registrationRepository;
    ISkierRepository skierRepository;
    ICourseRepository courseRepository;
    @Override
    public List<Registration> retrieveAllRegistrations() {
        return registrationRepository.findAll();
    }

    @Override
    public Registration addRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public Registration updateRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public Registration retrieveRegistration(long numRegistration) {
        return registrationRepository.findById(numRegistration).orElse(null);
    }

    @Override
    public void deleteRegistration(long numRegistration) {
        registrationRepository.deleteById(numRegistration);
    }

    @Override
    public Registration addRegistrationAndAssignToSkier(Registration registration, Long numSkieur) {
        Skier skier = skierRepository.findById(numSkieur).orElseThrow(() -> new RuntimeException("Skier not found"));
        registration.setSkier(skier);
        return registrationRepository.save(registration);
    }

    @Override
    public Registration assignRegistrationToCourse(Long numRegistration, Long numCourse) {
        Registration registration = registrationRepository.findById(numRegistration).orElseThrow(() -> new RuntimeException("Registration not found"));
        Course course = courseRepository.findById(numCourse).orElseThrow(() -> new RuntimeException("Course not found"));
        registration.setCourse(course);
        return registrationRepository.save(registration);
    }

    @Override
    public Registration addRegistrationAndAssignToSkierAndCourse(Registration registration, Long numSkier, Long numCourse) {
        Skier skier = skierRepository.findById(numSkier).orElseThrow(() -> new RuntimeException("Skier not found"));
        Course course = courseRepository.findById(numCourse).orElseThrow(() -> new RuntimeException("Course not found"));

        if (course.getTypeCourse() == TypeCourse.COLELCTIVE_CHILD ||
                course.getTypeCourse() == TypeCourse.COLELCTIVE_ADULT) {

            int currentSkiers = course.getRegistrations().size();
            if (currentSkiers >= 6) {
                throw new RuntimeException("Course is full, max 6 skiers allowed");
            }

            int age = Period.between(skier.getDateOfBirth(), LocalDate.now()).getYears(); // assume you have getAge() in Skier
            if ((course.getTypeCourse() == TypeCourse.COLELCTIVE_CHILD && age >= 18) ||
                    (course.getTypeCourse() == TypeCourse.COLELCTIVE_ADULT && age < 18)) {
                throw new RuntimeException("Skier age does not match course type");
            }
        }
        registration.setSkier(skier);
        skier.getRegistrations().add(registration);
        registration.setCourse(course);
        course.getRegistrations().add(registration);

        return registrationRepository.save(registration);
    }

}
