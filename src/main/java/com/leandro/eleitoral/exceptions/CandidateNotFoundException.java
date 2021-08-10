package com.leandro.eleitoral.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CandidateNotFoundException extends Exception {

    public CandidateNotFoundException(int id) {
        super("Candidato com id " + id + " não encontrado no banco de dados!");
        getMessage();
    }
}
