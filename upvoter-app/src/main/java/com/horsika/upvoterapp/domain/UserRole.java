package com.horsika.upvoterapp.domain;

public enum UserRole {

    USER("User"),
    ADMIN("Admin");

    private final String displayName;

    UserRole(String displayName) {
        this.displayName = displayName;
    }
}
