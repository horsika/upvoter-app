package com.horsika.upvoterapp.dto;

import lombok.Data;

@Data
public class RegisterLoginCommand {
    private String userName;
    private String pass;
}
