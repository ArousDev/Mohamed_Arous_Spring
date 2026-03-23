package tn.esprit.mohamed_arous.services.interfaces;

import tn.esprit.mohamed_arous.entities.Piste;

import java.util.List;

public interface IPisteServices {
    List<Piste> retrieveAllPistes();
    Piste addPiste(Piste piste);
    Piste updatePiste(Piste piste);
    Piste retrievePiste(long numPiste);
    void deletePiste(long numPiste);
}
