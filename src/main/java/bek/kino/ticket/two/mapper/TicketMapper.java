package bek.kino.ticket.two.mapper;


import bek.kino.ticket.two.dto.TicketDTO;
import bek.kino.ticket.two.model.Tickets;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    TicketDTO toDto(Tickets tickets);
    Tickets toModel(TicketDTO ticketDTO);

    List<TicketDTO> toDtoList(List<Tickets> list);
    List<Tickets> toTicketList(List<TicketDTO> list);
}
