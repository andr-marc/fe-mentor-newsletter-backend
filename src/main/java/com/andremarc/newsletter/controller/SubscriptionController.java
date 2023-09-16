package com.andremarc.newsletter.controller;

import com.andremarc.newsletter.entity.Subscription;
import com.andremarc.newsletter.model.ApiResponse;
import com.andremarc.newsletter.service.SubscriptionService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/newsletter")
public class SubscriptionController {
    private final SubscriptionService service;
    @PostMapping
    public ResponseEntity<ApiResponse<Subscription>> create(@RequestBody Subscription subscription){
        ApiResponse<Subscription> response = service.create(subscription);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
