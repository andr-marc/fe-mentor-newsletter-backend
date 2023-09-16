package com.andremarc.newsletter.service;

import com.andremarc.newsletter.entity.Subscription;
import com.andremarc.newsletter.model.ApiResponse;
import com.andremarc.newsletter.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
    private final SubscriptionRepository repository;

    public ApiResponse<Subscription> create(Subscription subscription) {
        ApiResponse<Subscription> response = new ApiResponse<>();

        Optional<Subscription> subscriptionOptional = repository.findByEmail(subscription.getEmail());
        if (subscriptionOptional.isPresent())
            return response.of(HttpStatus.BAD_REQUEST, "O email já está cadastrado");

        return response.of(HttpStatus.CREATED, "E-mail cadastrado com sucesso!", repository.save(subscription));
    }
}
