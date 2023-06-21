package bek.kino.ticket.two.impl;

import bek.kino.ticket.two.model.Comment;
import bek.kino.ticket.two.repo_services.CommentRepoInterface;
import bek.kino.ticket.two.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CommentRepoImpl implements CommentRepoInterface {

    private final CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentByUserId(Long id) {
        return commentRepository.findCommentByUserId(id);
    }
}
