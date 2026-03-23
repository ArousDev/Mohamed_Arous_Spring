package tn.esprit.mohamed_arous.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.mohamed_arous.entities.Instructor;
import tn.esprit.mohamed_arous.services.interfaces.IInstructorServices;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    private final IInstructorServices instructorService;

    public InstructorController(IInstructorServices instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping("/add")
    public Instructor addInstructor(@RequestBody Instructor instructor) {
        return instructorService.addInstructor(instructor);
    }

    @GetMapping("/retrieve/{numInstructor}")
    public Instructor retrieveInstructor(@PathVariable long numInstructor) {
        return instructorService.retrieveInstructor(numInstructor);
    }

    @PutMapping("/update")
    public Instructor updateInstructor(@RequestBody Instructor instructor) {
        return instructorService.updateInstructor(instructor);
    }

    @DeleteMapping("/remove/{numInstructor}")
    public void deleteInstructor(@PathVariable("numInstructor") Long numInstructor) {
        instructorService.deleteInstructor(numInstructor);
    }

    @GetMapping("/retrieve-all")
    public List<Instructor> retrieveAllInstructors() {
        return instructorService.retrieveAllInstructors();
    }
}
