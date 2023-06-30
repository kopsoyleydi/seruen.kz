package bek.kino.ticket.two.api;


import bek.kino.ticket.two.dto.HallDTO;
import bek.kino.ticket.two.services.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class HallController {

	private final HallService hallService;

	@GetMapping(value = "/getAllHalls")
	public List<HallDTO> getAllHalls() {
		return hallService.getAllHalls();
	}

	@PostMapping(value = "/addHall/{id}")
	public HallDTO addHall(@PathVariable(name = "id") Long id) {
		return hallService.getHallById(id);
	}
}
