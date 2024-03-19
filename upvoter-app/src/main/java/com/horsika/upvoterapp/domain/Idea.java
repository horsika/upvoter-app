package com.horsika.upvoterapp.domain;

import com.horsika.upvoterapp.dto.IdeaCommand;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(schema = "upvoter")
public class Idea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idea_id")
    private Long ideaId;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated
    @Column(name = "accepted")
    private IdeaStatus status;

    @OneToMany(mappedBy = "idea")
    private List<Vote> votes;

    public Idea(IdeaCommand ideaComm) {
        this.name = ideaComm.getTitle();
        this.description = ideaComm.getDescription();
        this.status = IdeaStatus.NO_DECISION;
    }
}
