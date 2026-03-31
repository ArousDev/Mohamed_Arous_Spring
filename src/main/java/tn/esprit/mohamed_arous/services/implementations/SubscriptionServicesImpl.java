package tn.esprit.mohamed_arous.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.mohamed_arous.entities.Subscription;
import tn.esprit.mohamed_arous.entities.TypeSubscription;
import tn.esprit.mohamed_arous.repositories.ISubscriptionRepository;
import tn.esprit.mohamed_arous.services.interfaces.ISubscriptionServices;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class SubscriptionServicesImpl implements ISubscriptionServices {
    ISubscriptionRepository subscriptionRepository;
    @Override
    public List<Subscription> retrieveAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Subscription addSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription retrieveSubscription(long numSubscription) {
        return subscriptionRepository.findById(numSubscription).orElse(null);
    }

    @Override
    public void deleteSubscription(long numSubscription) {
        subscriptionRepository.deleteById(numSubscription);
    }

    @Override
    public Set<Subscription> getSubscriptionByType(TypeSubscription type) {
        return subscriptionRepository.findByTypeSub(type);
    }

    @Override
    public List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        return subscriptionRepository.findByStartDateGreaterThanEqualAndEndDateLessThanEqual(startDate, endDate);    }
}
