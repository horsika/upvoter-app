package com.horsika.upvoterapp.repository;

import com.horsika.upvoterapp.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    @Query("SELECT u FROM AppUser u WHERE u.userName = :username")
    Optional<AppUser> findByUsername(@Param("username") String username);
}
