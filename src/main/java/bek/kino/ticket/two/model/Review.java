package bek.kino.ticket.two.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comment")
@Getter
@Setter
public class Review extends BaseModel {

	private String comment;

	@ManyToOne
	private Event event;

	@ManyToOne
	private User user;
}
