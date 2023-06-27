package bek.kino.ticket.two.dto;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventDTO {

    private Long id;
    private String eventName;
    private String author;
    private String event_date;
    private String pictureLink;

    private int price;
    @ManyToOne
    private HallDTO hall;

}
