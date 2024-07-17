package com.naveen.smad.analytics;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analytics")
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://127.0.0.1:5173")
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class AnalyticsController {
    private final AnalyticsRepository analyticsRepository;

    @GetMapping("/{accountId}")
    public ResponseEntity<Analytics> findById(@PathVariable Long accountId){
        Analytics analytics = analyticsRepository.findBySocialAccountId(accountId);
        return ResponseEntity.ok(analytics);
    }
}
