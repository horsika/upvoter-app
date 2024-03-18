package com.horsika.upvoterapp.repository;

import com.horsika.upvoterapp.domain.Idea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IdeaRepository extends JpaRepository<Idea, Long> {

    List<Idea> findAllByAcceptedIsTrue();

    List<Idea> findAllByAcceptedIsFalse();

    Optional<Idea> findIdeaByIdeaId(Long id);
}
