package bek.kino.ticket.two.BodySample;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Balance {
	private int balance;
	//эти классы нужны чтобы
	//коректировать requestBody из рест контроллеров, они как их схема
	private Long user_id;
}
