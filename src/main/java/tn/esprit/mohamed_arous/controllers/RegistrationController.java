package tn.esprit.mohamed_arous.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.mohamed_arous.entities.Registration;
import tn.esprit.mohamed_arous.services.interfaces.IRegistrationServices;

import java.util.List;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private final IRegistrationServices registrationService;

    public RegistrationController(IRegistrationServices registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/add")
    public Registration addRegistration(@RequestBody Registration registration) {
        return registrationService.addRegistration(registration);
    }

    @GetMapping("/retrieve/{numRegistration}")
    public Registration retrieveRegistration(@PathVariable long numRegistration) {
        return registrationService.retrieveRegistration(numRegistration);
    }

    @PutMapping("/update")
    public Registration updateRegistration(@RequestBody Registration registration) {
        return registrationService.updateRegistration(registration);
    }

    @DeleteMapping("/remove/{numRegistration}")
    public void deleteRegistration(@PathVariable("numRegistration") Long numRegistration) {
        registrationService.deleteRegistration(numRegistration);
    }

    @GetMapping("/retrieve-all")
    public List<Registration> retrieveAllRegistrations() {
        return registrationService.retrieveAllRegistrations();
    }
}
