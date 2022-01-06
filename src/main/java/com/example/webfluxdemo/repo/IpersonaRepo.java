package com.example.webfluxdemo.repo;

import com.example.webfluxdemo.modelo.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IpersonaRepo {

    Mono<Persona> registrar(Persona persona);
    Mono<Persona> modificar(Persona persona);
    Flux<Persona> listar();
    Mono<Persona> listarId(Integer id);
    Mono<Void> eliminar(Integer id);
}
