package bek.kino.ticket.two.dto;


import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDTO {

    private Long id;
    private String comment;
    @ManyToOne
    private EventDTO event;
    @ManyToOne
    private UserDTO user;
}
