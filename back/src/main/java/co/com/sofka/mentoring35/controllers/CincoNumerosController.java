package co.com.sofka.mentoring35.controllers;

import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.sofka.mentoring35.DTO.CincoNumerosDTO;
import co.com.sofka.mentoring35.model.CincoNumeros;
import co.com.sofka.mentoring35.repository.CincoNumerosRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/r")
public class CincoNumerosController {

    private CincoNumerosRepository cincoNumerosRepository;

    @Autowired
    public CincoNumerosController(CincoNumerosRepository cincoNumerosRepository) {
        this.cincoNumerosRepository = cincoNumerosRepository;
    }

   @PostMapping("")
    public Mono<CincoNumeros> post(@RequestBody CincoNumerosDTO request) {
        return Mono.just(new CincoNumeros()).map(entity -> {
            entity.setDate(new Date());
            entity.setOrginalList(request.getList());
            return entity;
        }).map(entity -> {
            var list = Stream.of(request.getList().split(","))
                .map(p -> p.trim())
                    .map(p-> p =  (int) Math.floor(Math.random()*45+1)+"")
                .collect(Collectors.toList());
            Collections.shuffle(list);
            var randomList = list.stream().collect(Collectors.joining(","));
            entity.setRandomList(randomList);
            return entity;
        }).flatMap(cincoNumerosRepository::save);
    }

    @GetMapping("")
    public Flux<CincoNumeros> get() {
        return cincoNumerosRepository.findAll();
    }
}
