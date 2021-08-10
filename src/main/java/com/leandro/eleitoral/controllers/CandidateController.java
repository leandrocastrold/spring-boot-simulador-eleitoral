package com.leandro.eleitoral.controllers;

import com.leandro.eleitoral.dtos.CandidateDTO;
import com.leandro.eleitoral.exceptions.CandidateNotFoundException;
import com.leandro.eleitoral.models.Candidate;
import com.leandro.eleitoral.repositories.CandidateRepository;
import com.leandro.eleitoral.services.CandidateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")


public class CandidateController {

    @Autowired
    private CandidateServices candidateServices;
    private CandidateRepository r;

    @CrossOrigin
    @GetMapping("/candidates/total")
    public ResponseEntity<Long> getTotal() {
        long count = candidateServices.getTotal();
        return new ResponseEntity<>(candidateServices.getTotal(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/candidates/validvotes")
    public ResponseEntity<Integer> getTotalValidVotes() {
        return new ResponseEntity<>(candidateServices.getTotalValidVotes(), HttpStatus.OK);
    }

    @GetMapping("/candidates")
    @CrossOrigin
    public ResponseEntity<List<CandidateDTO>> getCandidateList(@PageableDefault(page = 0, size = 5, sort="id", direction = Sort.Direction.ASC) Pageable pageable) {
    return new ResponseEntity<>(candidateServices.getList(pageable), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/candidates/{id}")
    public ResponseEntity<CandidateDTO> candidateDTO(@PathVariable int id) throws CandidateNotFoundException {
        return new ResponseEntity<>(candidateServices.getById(id), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/candidates/number/{number}")
    public ResponseEntity<Candidate> findByNumber(@PathVariable int number){
        return new ResponseEntity<>(candidateServices.getByNumber(number), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/savecandidate")
    public void createCandidate(@RequestBody @Valid CandidateDTO candidateDTO) {
        candidateServices.create(candidateDTO);
    }

    @CrossOrigin
    @GetMapping("/vote/{id}")
    public void voteCandidate(@PathVariable int id) throws CandidateNotFoundException {
      candidateServices.addVote(id);
    }

    @CrossOrigin
    @PutMapping("/updatecandidate/{id}")
    public void updateCandidate(@PathVariable int id, @RequestBody CandidateDTO candidateDTO) throws Exception {
        candidateServices.update(id, candidateDTO);
    }

    @CrossOrigin
    @DeleteMapping("/deletecandidate/{id}")
    public void deleteCandidate(@PathVariable int id) throws Exception {
        candidateServices.delete(id);
    }


}
