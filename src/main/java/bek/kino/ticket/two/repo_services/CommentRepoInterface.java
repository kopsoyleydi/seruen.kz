package bek.kino.ticket.two.repo_services;

import bek.kino.ticket.two.model.Comment;

import java.util.List;

public interface CommentRepoInterface {
    public List<Comment> getAllComments();

    public Comment addComment(Comment comment);

    public List<Comment> getCommentByUserId(Long id);
}
