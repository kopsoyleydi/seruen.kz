package bek.kino.ticket.two;

import bek.kino.ticket.two.model.Tickets;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailTicketSender {

	private final JavaMailSender mailSender;

	public void sendEmail(String toEmail,
	                      String subject,
	                      Tickets tickets){
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("omyrzakovbeksultan1@gmail.com");
		message.setTo(toEmail);
		String body = "Event name: "+tickets.getEvent().getEventName() +
				", your hall is: " + tickets.getEvent().getHall().getId() + ", your place in this: "
				+ tickets.getPlace() + ", event date: " + tickets.getEvent().getEvent_date() + ", ticket prime code: "
				+ tickets.getPrimeCodeTicket() + ", please scan this code. ";
		message.setText(body);
		message.setSubject(subject);

		mailSender.send(message);
		System.out.println("Mail send success");
	}
}
