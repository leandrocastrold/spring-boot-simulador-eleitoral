package com.leandro.eleitoral.services;

import com.leandro.eleitoral.dtos.CandidateDTO;
import com.leandro.eleitoral.exceptions.CandidateNotFoundException;
import com.leandro.eleitoral.models.Candidate;
import com.leandro.eleitoral.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateServices {


    @Autowired
    private CandidateRepository candidateRepository;


    public List<CandidateDTO> getList(Pageable pageable) {
        Page<Candidate> candidates = candidateRepository.findAll(pageable);
        List<CandidateDTO> candidateDTOS = new ArrayList<>();
        candidates.forEach(cdt -> {
            candidateDTOS.add(conversorToDTO(cdt));
        });
        return candidateDTOS;
    }


    public CandidateDTO getById(int id) throws CandidateNotFoundException {
        Candidate candidate = verifyIfCandidateExists(id);
        CandidateDTO candidateDTO = conversorToDTO(candidate);
        return candidateDTO;
    }

    public Candidate getByNumber (int number) {
        Candidate candidate = candidateRepository.findByNumber(number);
        return candidate;
    };

    public void create(CandidateDTO candidateDTO) {
       Candidate candidate = conversorToCandidate(candidateDTO);
       System.out.println("CREATE: " + candidate);
       candidateRepository.save(candidate);
    }

    public void addVote (int id) throws CandidateNotFoundException {
        Candidate candidate = verifyIfCandidateExists(id);
        candidate.addVote();
        System.out.println(candidate);
        candidateRepository.save(candidate);
    }

    public void delete(int id) throws Exception {
        Candidate candidate = verifyIfCandidateExists(id);
        candidateRepository.delete(candidate);
    }

    public void update(int id, CandidateDTO candidateDTO) throws CandidateNotFoundException{
        Candidate candidate = verifyIfCandidateExists(id);
        candidate.setName(candidateDTO.getName());
        candidate.setGender(candidateDTO.getGender());
        candidate.setNumber(candidateDTO.getNumber());
        candidate.setState(candidateDTO.getState());
        candidate.setParty(candidateDTO.getParty());
        System.out.println("PUT: " + candidate);
        candidateRepository.save(candidate);
    }

    // Auxiliares

    private Candidate verifyIfCandidateExists(int id) throws CandidateNotFoundException {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException(id));
        return candidate;
    }

    private Candidate conversorToCandidate (CandidateDTO candidateDTO) {
        Candidate candidate = new Candidate(
                candidateDTO.getName(),
                candidateDTO.getNumber(),
                candidateDTO.getGender(),
                candidateDTO.getState(),
                candidateDTO.getParty()
        );
        return  candidate;
    }

    private CandidateDTO conversorToDTO(Candidate candidate) {
        CandidateDTO dto = new CandidateDTO(
                candidate.getId(),
                candidate.getName(),
                candidate.getNumber(),
                candidate.getGender(),
                candidate.getState(),
                candidate.getParty());
                dto.setVotes(candidate.getVotes());
        return dto;
    }

    public Integer getTotalValidVotes() {
        Optional<Integer> result = candidateRepository.getTotalVotes();
        int amount = 0;
        if (result.isPresent()) {
           amount = result.get();
        }
        return amount;
    }

    public long getTotal() {
        return candidateRepository.count();
    }
}
