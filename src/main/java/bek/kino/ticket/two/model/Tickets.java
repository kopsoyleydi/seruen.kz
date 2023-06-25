package bek.kino.ticket.two.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tickets")
@Getter
@Setter
public class Tickets extends BaseModel{

    @ManyToOne
    private Event event;

    @ManyToOne
    private User user;

    @Column(name = "prime_code_ticket")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long primeCodeTicket;
}
