package com.horsika.upvoterapp.controller;

import com.horsika.upvoterapp.dto.VoteCommand;
import com.horsika.upvoterapp.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/votes")
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @PostMapping("/vote")
    public ResponseEntity<Void> castVote(@RequestBody VoteCommand voteCommand,
                                         @RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String token) {
        voteService.castVote(voteCommand, token);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
