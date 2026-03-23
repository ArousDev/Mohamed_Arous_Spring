package tn.esprit.mohamed_arous.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.mohamed_arous.entities.Subscription;
import tn.esprit.mohamed_arous.entities.TypeSubscription;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface ISubscriptionRepository extends JpaRepository<Subscription,Long> {
    Set<Subscription> findByTypeSub(TypeSubscription type);

    List<Subscription> findByStartDateGreaterThanEqualAndEndDateLessThanEqual(LocalDate startDate, LocalDate endDate);
}
