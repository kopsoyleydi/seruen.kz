package bek.kino.ticket.two.repository;

import bek.kino.ticket.two.model.Event;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
@Transactional
public interface EventRepository extends JpaRepository<Event,Long> {
    Event findAllById(Long eventId);

    Event findAllById(RequestBody eventId);
}
