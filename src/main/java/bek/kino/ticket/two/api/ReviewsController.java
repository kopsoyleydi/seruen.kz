package bek.kino.ticket.two.api;


import bek.kino.ticket.two.BodySample.ReviewSample;
import bek.kino.ticket.two.dto.ReviewDTO;
import bek.kino.ticket.two.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ReviewsController {

	private final ReviewService reviewService;

	@GetMapping(value = "/getAllComments")
	public List<ReviewDTO> getAllComments() {
		return reviewService.getAllComments();
	}

	@GetMapping(value = "/getAllCommentsByUserId/{id}")
	public List<ReviewDTO> getAllCommentByUserId(@PathVariable(name = "id") Long id) {
		return reviewService.getCommentByUserId(id);
	}

	@GetMapping(value = "/getCommentByEventId/{id}")
	public List<ReviewDTO> getAllCommentsByEventId(@PathVariable(name = "id") Long id){
		return reviewService.getAllCommentsByEventId(id);
	}

	@PostMapping(value = "/addReview")
	public ReviewDTO addReview(@RequestBody ReviewSample reviewSample){
		return reviewService.addReview(reviewSample);
	}
}
