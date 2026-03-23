package tn.esprit.mohamed_arous.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.mohamed_arous.entities.Piste;
import tn.esprit.mohamed_arous.repositories.IPisteRepository;
import tn.esprit.mohamed_arous.services.interfaces.IPisteServices;

import java.util.List;

@Service
@AllArgsConstructor
public class PisteServicesImpl implements IPisteServices {
    IPisteRepository pisteRepository;
    @Override
    public List<Piste> retrieveAllPistes() {
        return pisteRepository.findAll();
    }

    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste retrievePiste(long numPiste) {
        return pisteRepository.findById(numPiste).orElse(null);
    }

    @Override
    public void deletePiste(long numPiste) {
        pisteRepository.deleteById(numPiste);
    }
}
