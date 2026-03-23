package tn.esprit.mohamed_arous.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.mohamed_arous.entities.Skier;
import tn.esprit.mohamed_arous.services.interfaces.ISkierServices;

import java.util.List;

@RestController
@RequestMapping("/skier")
public class SkierController {

    private final ISkierServices skierService;

    public SkierController(ISkierServices skierService) {
        this.skierService = skierService;
    }

    @PostMapping("/add")
    public Skier addSkier(@RequestBody Skier skier) {
        return skierService.addSkier(skier);
    }

    @GetMapping("/retrieve/{numSkier}")
    public Skier retrieveSkier(@PathVariable long numSkier) {
        return skierService.retrieveSkier(numSkier);
    }

    @PutMapping("/update")
    public Skier updateSkier(@RequestBody Skier skier) {
        return skierService.updateSkier(skier);
    }

    @DeleteMapping("/remove/{numSkier}")
    public void deleteSkier(@PathVariable("numSkier") Long numSkier) {
        skierService.deleteSkier(numSkier);
    }

    @GetMapping("/retrieve-all")
    public List<Skier> retrieveAllSkiers() {
        return skierService.retrieveAllSkiers();
    }
}
