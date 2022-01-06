package com.example.webfluxdemo.repo;

import com.example.webfluxdemo.modelo.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepoImpl implements IpersonaRepo{

    private static final Logger log = LoggerFactory.getLogger(PersonaRepoImpl.class);

    @Override
    public Mono<Persona> registrar(Persona persona) {
        log.info(persona.toString());
        return Mono.just(persona);
    }

    @Override
    public Mono<Persona> modificar(Persona persona) {
        log.info(persona.toString());
        return Mono.just(persona);
    }

    @Override
    public Flux<Persona> listar() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"juan"));
        personas.add(new Persona(2,"jose"));
        personas.add(new Persona(3,"pedro"));

        return Flux.fromIterable(personas);
    }

    @Override
    public Mono<Persona> listarId(Integer id) {
        return Mono.just(new Persona(id,"juan"));
    }

    @Override
    public Mono<Void> eliminar(Integer id) {
        return Mono.empty();
    }
}
