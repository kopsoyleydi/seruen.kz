package bek.kino.ticket.two.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketDTO {
    private Long id;
    private Long primeCodeTicket;
    private Long event_id;
    private Long user_id;
}
