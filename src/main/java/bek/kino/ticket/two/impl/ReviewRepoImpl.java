package bek.kino.ticket.two.impl;

import bek.kino.ticket.two.model.Review;
import bek.kino.ticket.two.repo_services.ReviewRepoInterface;
import bek.kino.ticket.two.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ReviewRepoImpl implements ReviewRepoInterface {

    private final ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllComments() {
        return reviewRepository.findAll();
    }

    @Override
    public Review addComment(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getCommentByUserId(Long id) {
        return reviewRepository.findAllById(id);
    }
}
