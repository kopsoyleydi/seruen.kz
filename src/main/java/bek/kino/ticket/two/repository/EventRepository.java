package bek.kino.ticket.two.repository;

import bek.kino.ticket.two.model.Event;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface EventRepository extends JpaRepository<Event, Long> {
	Event findAllById(Long id);

	List<Event> findAll();

}
