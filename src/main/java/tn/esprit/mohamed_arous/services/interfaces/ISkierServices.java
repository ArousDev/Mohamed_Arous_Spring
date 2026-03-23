package tn.esprit.mohamed_arous.services.interfaces;

import tn.esprit.mohamed_arous.entities.Skier;
import tn.esprit.mohamed_arous.entities.TypeSubscription;

import java.util.List;

public interface ISkierServices {
    List<Skier> retrieveAllSkiers();
    Skier addSkier(Skier skier);
    Skier updateSkier(Skier skier);
    Skier retrieveSkier(long numSkier);
    void deleteSkier(long numSkier);
    Skier assignSkierToPiste(Long numSkier, Long numPiste);
    Skier addSkierAndAssignToCourse(Skier skier, Long numCourse);
    List<Skier> retrieveSkiersBySubscriptionType(TypeSubscription typeSubscription);
}
