package com.horsika.upvoterapp.repository;

import com.horsika.upvoterapp.domain.Idea;
import com.horsika.upvoterapp.domain.IdeaStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IdeaRepository extends JpaRepository<Idea, Long> {

    List<Idea> findAllByStatus(IdeaStatus status);

    Optional<Idea> findIdeaByIdeaId(Long id);
}
