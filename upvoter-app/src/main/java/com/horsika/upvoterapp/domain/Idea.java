package com.horsika.upvoterapp.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Idea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idea_id")
    private Long ideaId;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "accepted")
    private Boolean accepted;

    // TODO constructor based on dto
}
