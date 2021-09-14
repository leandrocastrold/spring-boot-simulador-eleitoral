package com.leandro.eleitoral.repositories;

import com.leandro.eleitoral.models.Candidate;
import org.hibernate.sql.Select;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
  public Candidate findByNumber(int number);

  @Query(value = "SELECT SUM (votes) FROM Candidate m ")
  public Optional<Integer> getTotalVotes();
}