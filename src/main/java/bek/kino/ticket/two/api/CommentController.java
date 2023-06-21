package bek.kino.ticket.two.api;


import bek.kino.ticket.two.dto.CommentDTO;
import bek.kino.ticket.two.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    @GetMapping(value = "/getAllComments")
    public List<CommentDTO> getAllComments(){
        return commentService.getAllComments();
    }

    @GetMapping(value = "/getAllCommentsByUserId/{id}")
    public List<CommentDTO> getAllCommentByUserId(@PathVariable(name = "id")Long id){
        return commentService.getCommentByUserId(id);
    }
}
