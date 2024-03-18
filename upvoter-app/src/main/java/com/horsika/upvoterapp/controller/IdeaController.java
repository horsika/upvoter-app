package com.horsika.upvoterapp.controller;

import com.horsika.upvoterapp.dto.IdeaCommand;
import com.horsika.upvoterapp.dto.IdeaListItem;
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

    @GetMapping("/list-enabled")
    public ResponseEntity<List<IdeaListItem>> listEnabledIdeas() {
        return new ResponseEntity<>(ideaService.listEnabledIdeas(), HttpStatus.OK);
    }

    @GetMapping("/list-disabled")
    public ResponseEntity<List<IdeaListItem>> listDisabledIdeas() {
        return new ResponseEntity<>(ideaService.listDisabledIdeas(), HttpStatus.OK);
    }

    @PostMapping("create-idea")
    public ResponseEntity<Void> createIdea(@RequestBody IdeaCommand ideaCommand) {
        ideaService.createIdea(ideaCommand);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("enable-idea")
    public ResponseEntity<Void> enableIdea(@RequestBody Long id) {
        ideaService.enableIdea(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
