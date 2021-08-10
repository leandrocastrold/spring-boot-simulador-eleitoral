package com.leandro.eleitoral.repositories;

import com.leandro.eleitoral.models.NotValidVote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotValidVoteRepository extends JpaRepository<NotValidVote, Integer> {
     public NotValidVote findByName(String name);
}
