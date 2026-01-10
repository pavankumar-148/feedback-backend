package com.example.feedback.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.feedback.model.Feedback;
import com.example.feedback.repository.FeedbackRepository;

@Service
public class FeedbackService {

    private final FeedbackRepository repo;

    public FeedbackService(FeedbackRepository repo) {
        this.repo = repo;
    }

    public Feedback saveFeedback(Feedback feedback) {
        return repo.save(feedback);
    }

    public List<Feedback> getAllFeedback() {
        return repo.findAll();
    }

    public double getAverageRating() {
        return repo.findAll()
                .stream()
                .mapToInt(Feedback::getRating)
                .average()
                .orElse(0.0);
    }
}
