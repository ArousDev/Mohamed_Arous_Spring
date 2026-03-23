package tn.esprit.mohamed_arous.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.mohamed_arous.entities.Piste;
import tn.esprit.mohamed_arous.services.interfaces.IPisteServices;

import java.util.List;

@RestController
@RequestMapping("/piste")
public class PisteController {

    private final IPisteServices pisteService;

    public PisteController(IPisteServices pisteService) {
        this.pisteService = pisteService;
    }

    @PostMapping("/add")
    public Piste addPiste(@RequestBody Piste piste) {
        return pisteService.addPiste(piste);
    }

    @GetMapping("/retrieve/{numPiste}")
    public Piste retrievePiste(@PathVariable long numPiste) {
        return pisteService.retrievePiste(numPiste);
    }

    @PutMapping("/update")
    public Piste updatePiste(@RequestBody Piste piste) {
        return pisteService.updatePiste(piste);
    }

    @DeleteMapping("/remove/{numPiste}")
    public void deletePiste(@PathVariable("numPiste") Long numPiste) {
        pisteService.deletePiste(numPiste);
    }

    @GetMapping("/retrieve-all")
    public List<Piste> retrieveAllPistes() {
        return pisteService.retrieveAllPistes();
    }
}
