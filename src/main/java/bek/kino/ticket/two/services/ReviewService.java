package bek.kino.ticket.two.services;


import bek.kino.ticket.two.dto.ReviewDTO;
import bek.kino.ticket.two.impl.ReviewRepoImpl;
import bek.kino.ticket.two.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

	private final ReviewMapper reviewMapper;

	private final ReviewRepoImpl commentRepo;

	public List<ReviewDTO> getAllComments() {
		return reviewMapper.toDtoList(commentRepo.getAllComments());
	}

	public List<ReviewDTO> getCommentByUserId(Long id) {
		return reviewMapper.toDtoList(commentRepo.getCommentByUserId(id));
	}
}
