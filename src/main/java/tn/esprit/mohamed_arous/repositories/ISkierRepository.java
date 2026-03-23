package tn.esprit.mohamed_arous.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.mohamed_arous.entities.Skier;
import tn.esprit.mohamed_arous.entities.TypeSubscription;

import java.util.List;

@Repository
public interface ISkierRepository extends JpaRepository<Skier,Long> {
    List<Skier> findBySubscriptionTypeSub(TypeSubscription typeSubscription);
}
