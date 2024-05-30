package com.pratik.service;

import com.pratik.model.PlanType;
import com.pratik.model.Subscription;
import com.pratik.model.User;

public interface SubscriptionService {

    Subscription createSubscription(User user);

    Subscription getUsersSubscription(Long userId) throws Exception;

    Subscription upgradeSubscription(Long userId, PlanType planType);

    boolean isValid(Subscription subscription);

}
