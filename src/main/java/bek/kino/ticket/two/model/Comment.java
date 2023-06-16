package bek.kino.ticket.two.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment extends BaseModel{

    private String comment;

    @ManyToOne
    private Event event;

    @ManyToOne
    private User user;
}
