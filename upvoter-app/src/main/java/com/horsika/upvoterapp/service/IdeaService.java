package com.horsika.upvoterapp.service;

import com.horsika.upvoterapp.domain.Idea;
import com.horsika.upvoterapp.domain.IdeaStatus;
import com.horsika.upvoterapp.dto.AcceptRejectIdeaCommand;
import com.horsika.upvoterapp.dto.IdeaCommand;
import com.horsika.upvoterapp.dto.IdeaListItem;
import com.horsika.upvoterapp.repository.IdeaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IdeaService {

    private final IdeaRepository ideaRepository;

    public List<IdeaListItem> listAcceptedIdeas() {
        return ideaRepository.findAllByStatus(IdeaStatus.ACCEPTED).stream().map(IdeaListItem::new).toList();
    }

    public List<IdeaListItem> listNoDecisionIdeas() {
        return ideaRepository.findAllByStatus(IdeaStatus.NO_DECISION).stream().map(IdeaListItem::new).toList();
    }

    public void createIdea(IdeaCommand ideaCommand) {
        ideaRepository.save(new Idea(ideaCommand));
    }

    public Idea findIdeaById(Long id) {
        return ideaRepository.findIdeaByIdeaId(id).orElseThrow();
    }

    public void enableIdea(AcceptRejectIdeaCommand command) {
        Idea idea = findIdeaById(command.getIdeaId());
        idea.setStatus(IdeaStatus.valueOf(command.getDecision()));
        ideaRepository.save(idea);
    }


}
