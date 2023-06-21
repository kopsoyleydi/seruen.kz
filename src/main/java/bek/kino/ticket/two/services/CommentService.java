package bek.kino.ticket.two.services;


import bek.kino.ticket.two.dto.CommentDTO;
import bek.kino.ticket.two.impl.CommentRepoImpl;
import bek.kino.ticket.two.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper commentMapper;

    private final CommentRepoImpl commentRepo;

    public List<CommentDTO> getAllComments(){
        return commentMapper.toDtoList(commentRepo.getAllComments());
    }

    public List<CommentDTO> getCommentByUserId(Long id){
        return commentMapper.toDtoList(commentRepo.getCommentByUserId(id));
    }
}
