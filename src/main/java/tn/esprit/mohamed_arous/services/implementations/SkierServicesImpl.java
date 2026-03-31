package tn.esprit.mohamed_arous.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.mohamed_arous.entities.*;
import tn.esprit.mohamed_arous.repositories.ICourseRepository;
import tn.esprit.mohamed_arous.repositories.IPisteRepository;
import tn.esprit.mohamed_arous.repositories.ISkierRepository;
import tn.esprit.mohamed_arous.services.interfaces.ISkierServices;

import java.util.List;

@Service
@AllArgsConstructor
public class SkierServicesImpl implements ISkierServices {
    ISkierRepository skierRepository;
    IPisteRepository pisteRepository;
    ICourseRepository courseRepository;

    @Override
    public List<Skier> retrieveAllSkiers() {
        return skierRepository.findAll();
    }

    @Override
    public Skier addSkier(Skier skier) {
        return skierRepository.save(skier);
    }

    @Override
    public Skier updateSkier(Skier skier) {
        return skierRepository.save(skier);
    }

    @Override
    public Skier retrieveSkier(long numSkier) {
        return skierRepository.findById(numSkier).orElse(null);
    }

    @Override
    public void deleteSkier(long numSkier) {
        skierRepository.deleteById(numSkier);
    }

    @Override
    public Skier assignSkierToPiste(Long numSkier, Long numPiste) {
        Skier skier = skierRepository.findById(numSkier).orElseThrow(() -> new RuntimeException("Skier not found"));
        Piste piste = pisteRepository.findById(numPiste).orElseThrow(() -> new RuntimeException("Piste not found"));
        skier.getPistes().add(piste);
        piste.getSkiers().add(skier);
        return skierRepository.save(skier);
    }

    @Override
    public Skier addSkierAndAssignToCourse(Skier skier, Long numCourse) {
        Course course = courseRepository.findById(numCourse).orElseThrow(() -> new RuntimeException("Course not found"));

        for (Registration reg : skier.getRegistrations()) {
            reg.setSkier(skier);
            reg.setCourse(course);
            course.getRegistrations().add(reg);
        }

        return skierRepository.save(skier);
    }

    @Override
    public List<Skier> retrieveSkiersBySubscriptionType(TypeSubscription typeSubscription) {
        return skierRepository.findBySubscriptionTypeSub(typeSubscription);
    }
}
