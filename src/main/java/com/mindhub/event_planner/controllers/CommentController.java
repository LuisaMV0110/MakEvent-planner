package com.mindhub.event_planner.controllers;

import com.mindhub.event_planner.dtos.CommentDTOA;
import com.mindhub.event_planner.dtos.notAccesibleForEveryone.CommentDTONA;
import com.mindhub.event_planner.models.*;
import com.mindhub.event_planner.services.CommentService;
import com.mindhub.event_planner.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/auth/all")
    public List<?> getAll(Authentication authentication){
        Customer customer = customerService.findByEmail(authentication.getName());
        List<CommentDTONA> comments = commentService.findAll();
        if(customer instanceof UserEntity){
            return ((UserEntity) customer).getComments().stream().map(CommentDTOA::new).collect(Collectors.toList());
        } else if(customer instanceof Manager){
            return comments.stream().filter(comment -> comment.getEvent().getManager().getEmail().equals(customer.getEmail())).collect(Collectors.toList());
        }
        return comments;
    }

    @GetMapping("/auth/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id, Authentication authentication){
        Customer customer = customerService.findByEmail(authentication.getName());
        Comment comment = commentService.findById(id);
        if ((comment != null && comment.getEvent().getManager() == customer) || customer instanceof Admin){
            return new ResponseEntity<>(new CommentDTONA(commentService.findById(id)), HttpStatus.OK);
        } else if (comment != null && comment.getEvent().getManager() != customer){
            return new ResponseEntity<>(new CommentDTOA(commentService.findById(id)), HttpStatus.OK);
        }
        return new ResponseEntity<>("An error occurred finding the comment with ID: " + id, HttpStatus.FORBIDDEN);
    }

    @GetMapping("/public/all")
    public List<CommentDTOA> getAll2(){
        return commentService.findAll2();
    }

    @GetMapping("/public/{id}")
    public ResponseEntity<?> getById2(@PathVariable Long id){
        return new ResponseEntity<>(new CommentDTOA(commentService.findById(id)), HttpStatus.OK);
    }
}
