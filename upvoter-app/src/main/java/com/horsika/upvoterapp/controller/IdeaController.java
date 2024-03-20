package com.horsika.upvoterapp.controller;

import com.horsika.upvoterapp.dto.AcceptRejectIdeaCommand;
import com.horsika.upvoterapp.dto.IdeaCommand;
import com.horsika.upvoterapp.dto.IdeaListItem;
import com.horsika.upvoterapp.dto.SessionVotes;
import com.horsika.upvoterapp.service.IdeaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ideas")
@RequiredArgsConstructor
public class IdeaController {

    private final IdeaService ideaService;

    @PostMapping("/list-enabled")
    public ResponseEntity<List<IdeaListItem>> listAcceptedIdeas(@RequestBody SessionVotes sessionVotes) {
        return new ResponseEntity<>(ideaService.listAcceptedIdeas(sessionVotes), HttpStatus.OK);
    }

    @GetMapping("/list-disabled")
    public ResponseEntity<List<IdeaListItem>> listNoDecisionIdeas() {
        return new ResponseEntity<>(ideaService.listNoDecisionIdeas(), HttpStatus.OK);
    }

    @PostMapping("create-idea")
    public ResponseEntity<Void> createIdea(@RequestBody IdeaCommand ideaCommand) {
        ideaService.createIdea(ideaCommand);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("decide-idea-status")
    public ResponseEntity<Void> enableIdea(@RequestBody AcceptRejectIdeaCommand command) {
        ideaService.enableIdea(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
