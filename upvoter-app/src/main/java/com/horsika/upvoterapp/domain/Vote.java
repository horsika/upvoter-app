package com.horsika.upvoterapp.domain;

import com.horsika.upvoterapp.dto.VoteCommand;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vote_id")
    private Long voteId;

    @Column(name= "vote_value")
    private Boolean voteValue;

    @ManyToOne
    @JoinColumn(name = "voter_id")
    private AppUser voter;

    @ManyToOne
    @JoinColumn(name = "idea_id")
    private Idea idea;

    public Vote(VoteCommand voteCommand, Idea idea) {
        this.voteValue = voteCommand.getVote();
        this.idea = idea;
    }
}
