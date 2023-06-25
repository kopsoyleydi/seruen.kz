package bek.kino.ticket.two.dto;


import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketDTO {
    private Long id;
    private Long primeCodeTicket;

    @ManyToOne
    private EventDTO event;
    @ManyToOne
    private UserDTO user;
}
