package bek.kino.ticket.two.repository;

import bek.kino.ticket.two.model.Review;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Transactional
public interface ReviewRepository extends JpaRepository<Review, Long> {

	@Query(value = "SELECT c FROM Review c WHERE c.user.id = :userId")
	List<Review> findAllById(@Param("userId") Long userId);
}
