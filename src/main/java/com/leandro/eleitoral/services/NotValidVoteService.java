package com.leandro.eleitoral.services;

import com.leandro.eleitoral.models.NotValidVote;
import com.leandro.eleitoral.repositories.NotValidVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NotValidVoteService {

    @Autowired
    private NotValidVoteRepository notValidVoteRepository;

    public String addNullVote() {
        NotValidVote notValidVote = notValidVoteRepository.findByName("nulo");
        if (notValidVote == null) {
            notValidVote = new NotValidVote("nulo");
        }
        System.out.println(notValidVote.toString());
        notValidVote.addVotes();
        notValidVoteRepository.save(notValidVote);
        return "Voto nulo Adicionado!";
    }

    public String addEmptyVote() {
        NotValidVote notValidVote = notValidVoteRepository.findByName("branco");
        if (notValidVote == null) {
            notValidVote = new NotValidVote("branco");
        }
        notValidVote.addVotes();
        notValidVoteRepository.save(notValidVote);
        return "Voto em Branco Adicionado!";
    }

    public int getNullVotes() {
        NotValidVote notValidVote = notValidVoteRepository.findByName("nulo");
        int amount = notValidVote.getVotes();
        return  amount;
    }

    public int getBlankVotes() {
        NotValidVote notValidVote = notValidVoteRepository.findByName("branco");
        int amount = notValidVote.getVotes();
        return amount;
    }
}
