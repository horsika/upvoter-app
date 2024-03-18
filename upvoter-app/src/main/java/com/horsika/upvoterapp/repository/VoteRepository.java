package com.horsika.upvoterapp.repository;

import com.horsika.upvoterapp.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
