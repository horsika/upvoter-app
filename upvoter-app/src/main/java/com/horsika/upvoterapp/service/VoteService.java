package com.horsika.upvoterapp.service;

import com.horsika.upvoterapp.domain.Idea;
import com.horsika.upvoterapp.domain.Vote;
import com.horsika.upvoterapp.dto.VoteCommand;
import com.horsika.upvoterapp.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final IdeaService ideaService;
    private final VoteRepository voteRepository;

    public void castVote(VoteCommand voteCommand) {
        Idea idea = ideaService.findIdeaById(voteCommand.getIdeaId());
        voteRepository.save(new Vote(voteCommand, idea));
    }
}
