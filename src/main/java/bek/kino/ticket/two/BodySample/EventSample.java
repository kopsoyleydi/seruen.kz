package bek.kino.ticket.two.BodySample;


import bek.kino.ticket.two.dto.HallDTO;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventSample {

	private Long id;
	private String eventName;
	private String author;
	private String event_date;
	private String pictureLink;

	private int price;
	private Long hall_id;
}
