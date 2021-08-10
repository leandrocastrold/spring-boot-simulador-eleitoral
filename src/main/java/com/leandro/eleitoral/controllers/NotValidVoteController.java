package com.leandro.eleitoral.controllers;

import com.leandro.eleitoral.services.NotValidVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/notvalid")
public class NotValidVoteController {

    @Autowired
    private NotValidVoteService notValidVoteService;

    @GetMapping("getnullvotes")
    @CrossOrigin
    public ResponseEntity<Integer> getNullVotes() {
        return new ResponseEntity<>(notValidVoteService.getNullVotes(), HttpStatus.OK);
    }

    @GetMapping("getblankvotes")
    @CrossOrigin
    public ResponseEntity<Integer> getBlankVotes() {
        return new ResponseEntity<>(notValidVoteService.getBlankVotes(), HttpStatus.OK);
    }

    @GetMapping("/nullvote")
    @CrossOrigin
    public ResponseEntity<String> addNullVote() {
      return new ResponseEntity<>(notValidVoteService.addNullVote(), HttpStatus.OK);
    }

    @GetMapping("blankvote")
    @CrossOrigin
    public ResponseEntity<String> addEmptyVote() {
        return new ResponseEntity<>(notValidVoteService.addEmptyVote(), HttpStatus.OK);
    }

}
