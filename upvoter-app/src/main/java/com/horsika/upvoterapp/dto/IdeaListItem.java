package com.horsika.upvoterapp.dto;

import lombok.Data;

@Data
public class IdeaListItem {

    private String title;
    private String description;
    private int upVotes;
    private int downVotes;

}
