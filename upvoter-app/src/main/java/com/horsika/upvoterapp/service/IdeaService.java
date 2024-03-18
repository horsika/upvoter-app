package com.horsika.upvoterapp.service;

import com.horsika.upvoterapp.domain.Idea;
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

    public List<IdeaListItem> listEnabledIdeas() {
        return ideaRepository.findAllByAcceptedIsTrue().stream().map(IdeaListItem::new).toList();
    }

    public List<IdeaListItem> listDisabledIdeas() {
        return ideaRepository.findAllByAcceptedIsFalse().stream().map(IdeaListItem::new).toList();
    }

    public void createIdea(IdeaCommand ideaCommand) {
        ideaRepository.save(new Idea(ideaCommand));
    }

    public Idea findIdeaById(Long id) {
        return ideaRepository.findIdeaByIdeaId(id).orElseThrow();
    }

    public void enableIdea(Long id) {
        Idea idea = findIdeaById(id);
        idea.setAccepted(Boolean.TRUE);
        ideaRepository.save(idea);
    }


}
