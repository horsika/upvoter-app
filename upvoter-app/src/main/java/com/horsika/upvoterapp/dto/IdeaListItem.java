package com.horsika.upvoterapp.dto;

import com.horsika.upvoterapp.domain.Idea;
import lombok.Data;

import java.util.stream.Collectors;

@Data
public class IdeaListItem {

    private String title;
    private String description;
    private int upVotes;
    private int downVotes;

    public IdeaListItem(Idea idea) {
        this.title = idea.getName();
        this.description = idea.getDescription();
        this.upVotes = (int) idea.getVotes().stream().filter(vote -> vote.getVoteValue() == Boolean.TRUE).count();
        this.downVotes = idea.getVotes().size() - this.upVotes;
    }
}
