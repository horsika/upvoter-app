package com.horsika.upvoterapp.dto;

import lombok.Data;

@Data
public class VoteCommand {
    private Boolean vote;
    private Long ideaId;
}
