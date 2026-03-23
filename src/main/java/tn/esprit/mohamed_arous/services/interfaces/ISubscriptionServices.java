package tn.esprit.mohamed_arous.services.interfaces;

import tn.esprit.mohamed_arous.entities.Subscription;
import tn.esprit.mohamed_arous.entities.TypeSubscription;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ISubscriptionServices {
    List<Subscription> retrieveAllSubscriptions();
    Subscription addSubscription(Subscription subscription);
    Subscription updateSubscription(Subscription subscription);
    Subscription retrieveSubscription(long numSubscription);
    void deleteSubscription(long numSubscription);
    Set<Subscription> getSubscriptionByType(TypeSubscription type);
    List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate);
}
