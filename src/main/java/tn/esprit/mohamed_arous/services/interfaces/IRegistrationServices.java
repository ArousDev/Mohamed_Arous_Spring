package tn.esprit.mohamed_arous.services.interfaces;

import tn.esprit.mohamed_arous.entities.Registration;

import java.util.List;

public interface IRegistrationServices {
    List<Registration> retrieveAllRegistrations();
    Registration addRegistration(Registration registration);
    Registration updateRegistration(Registration registration);
    Registration retrieveRegistration(long numRegistration);
    void deleteRegistration(long numRegistration);
    Registration addRegistrationAndAssignToSkier(Registration registration, Long numSkieur);
    Registration assignRegistrationToCourse(Long numRegistration, Long numCourse);
    Registration addRegistrationAndAssignToSkierAndCourse(Registration registration, Long numSkier, Long numCourse);
}
