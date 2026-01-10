package com.example.feedback.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.feedback.model.Feedback;
import com.example.feedback.service.FeedbackService;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "http://localhost:3000")
public class FeedbackController {

    private final FeedbackService service;

    public FeedbackController(FeedbackService service) {
        this.service = service;
    }

    @PostMapping
    public Feedback save(@RequestBody Feedback feedback) {
        return service.saveFeedback(feedback);
    }

    @GetMapping
    public List<Feedback> getAll() {
        return service.getAllFeedback();
    }

    @GetMapping("/average")
    public double average() {
        return service.getAverageRating();
    }
}
