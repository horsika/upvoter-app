package com.horsika.upvoterapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class SessionVotes {
    private List<Long> ideaIds;
}
