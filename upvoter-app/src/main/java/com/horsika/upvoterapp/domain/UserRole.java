package com.horsika.upvoterapp.domain;

public enum UserRole {

    ROLE_USER("User"),
    ROLE_ADMIN("Admin");

    private final String displayName;

    UserRole(String displayName) {
        this.displayName = displayName;
    }
}
