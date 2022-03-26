package co.com.sofka.mentoring35.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import co.com.sofka.mentoring35.model.CincoNumeros;

public interface CincoNumerosRepository extends ReactiveCrudRepository<CincoNumeros, String> {
    
}
