package com.horsika.upvoterapp.repository;

import com.horsika.upvoterapp.domain.Idea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdeaRepository extends JpaRepository<Idea, Long> {


}
