package com.leandro.eleitoral.services;

import com.leandro.eleitoral.dtos.CandidateDTO;
import com.leandro.eleitoral.exceptions.CandidateNotFoundException;
import com.leandro.eleitoral.models.Candidate;
import com.leandro.eleitoral.repositories.CandidateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
class CandidateServicesTest {

    @Mock
    private CandidateRepository repository;

    @InjectMocks
    private CandidateServices services;

    private Candidate candidate = new Candidate("Leandro Castro", 10, "M", "PE", "PDG");


    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldReturnANotNullPageableList() {
        List<Candidate> candidates = new ArrayList<>();
        candidates.add(new Candidate("Leandro Castro", 10, "M", "PE", "PDG"));
        candidates.add(new Candidate("Maísa Sobral", 20, "F", "SP", "PDD"));
        candidates.add(new Candidate("Vagner Soares", 30, "M", "PB", "PDC"));
        Pageable pageable = PageRequest.of(0, 5);
        Page<Candidate> page = new PageImpl<>(candidates);
        when(repository.findAll(pageable)).thenReturn((page));
        services.getList(pageable);
        assertNotNull(page);
    }

    @Test
    void shouldReturnCandidateNumberWhenIdIsPassed() throws CandidateNotFoundException {
        int id = 2;
        when(repository.findById(id)).thenReturn(Optional.of(candidate));    when(repository.findById(id)).thenReturn(Optional.of(candidate));
        services.getById(id);
        System.out.println(Optional.of(candidate));
        assertEquals(candidate.getNumber(), 10);
    }

    @Test
    void shouldReturnAValidCandidateNameWhenNumberIsPassed() {
        int number = 10;
        services.getByNumber(number);
        when(repository.findByNumber(number)).thenReturn(candidate);
        assertEquals("Leandro Castro", candidate.getName());
    }

    @Test
    void shouldReturnAValidCandidateAfterSave() {

        CandidateDTO dto = new CandidateDTO();
        BeanUtils.copyProperties(candidate, dto);
        when(repository.save(notNull())).thenReturn(candidate);
        Candidate candidateToReturn = services.create(dto);
        assertNotNull(candidateToReturn);
    }

    @Test
    void verifyIfTheDeleteMethodIsCalled() throws Exception {
        int id = 1;
        when(repository.findById(id)).thenReturn(Optional.of(candidate));
        services.delete(id);
        verify(repository, times(1)).delete(candidate);
    }

    @Test
    void verifyIfTheAddVoteMethodIsCalled() throws CandidateNotFoundException {
        int id = 1;
        when(repository.findById(id)).thenReturn(Optional.of(candidate));
        services.addVote(id);
        verify(repository, times(1)).save(candidate);
    }
}