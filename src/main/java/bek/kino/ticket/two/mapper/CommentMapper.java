package bek.kino.ticket.two.mapper;


import bek.kino.ticket.two.dto.CommentDTO;
import bek.kino.ticket.two.dto.EventDTO;
import bek.kino.ticket.two.model.Comment;
import bek.kino.ticket.two.model.Event;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentDTO toDto(Comment comment);
    Comment toModel(CommentDTO commentDTO);
    List<CommentDTO> toDtoList(List<Comment> list);
    List<Comment> toCommentList(List<CommentDTO> list);
}
