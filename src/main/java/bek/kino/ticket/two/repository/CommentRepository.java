package bek.kino.ticket.two.repository;

import bek.kino.ticket.two.model.Comment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Transactional
public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Query("SELECT c from Comment c where c.user.id = :userID")
    List<Comment> findCommentByUserId(@Param("userId") Long userId);
}
