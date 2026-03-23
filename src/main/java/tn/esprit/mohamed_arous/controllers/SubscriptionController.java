package tn.esprit.mohamed_arous.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.mohamed_arous.entities.Subscription;
import tn.esprit.mohamed_arous.services.interfaces.ISubscriptionServices;

import java.util.List;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

    private final ISubscriptionServices subscriptionService;

    public SubscriptionController(ISubscriptionServices subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/add")
    public Subscription addSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.addSubscription(subscription);
    }

    @GetMapping("/retrieve/{numSub}")
    public Subscription retrieveSubscription(@PathVariable long numSub) {
        return subscriptionService.retrieveSubscription(numSub);
    }

    @PutMapping("/update")
    public Subscription updateSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.updateSubscription(subscription);
    }

    @DeleteMapping("/remove/{numSub}")
    public void deleteSubscription(@PathVariable("numSub") Long numSub) {
        subscriptionService.deleteSubscription(numSub);
    }

    @GetMapping("/retrieve-all")
    public List<Subscription> retrieveAllSubscriptions() {
        return subscriptionService.retrieveAllSubscriptions();
    }
}
