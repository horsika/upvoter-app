package com.horsika.upvoterapp.dto;

import lombok.Data;

@Data
public class AcceptRejectIdeaCommand {

    private Long ideaId;
    private String decision;
}
