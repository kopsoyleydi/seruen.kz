package bek.kino.ticket.two.services;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class TicketNumberGenerator {
	private static final int TICKET_NUMBER_LENGTH = 6;
	private static final int MAX_TICKET_NUMBER = (int) Math.pow(10, TICKET_NUMBER_LENGTH);
	private Set<Integer> usedNumbers;
	private Random random;

	public TicketNumberGenerator() {
		usedNumbers = new HashSet<>();
		random = new Random();
	}

	public int generateTicketNumber() {
		if (usedNumbers.size() >= MAX_TICKET_NUMBER) {
			throw new IllegalStateException("All possible ticket numbers have been generated.");
		}
		int ticketNumber;
		do {
			ticketNumber = random.nextInt(MAX_TICKET_NUMBER);
		} while (usedNumbers.contains(ticketNumber));
		usedNumbers.add(ticketNumber);
		return ticketNumber;
	}
}
