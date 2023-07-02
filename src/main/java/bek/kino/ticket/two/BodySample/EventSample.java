package bek.kino.ticket.two.BodySample;


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
