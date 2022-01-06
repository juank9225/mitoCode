package com.example.webfluxdemo.controller;

import com.example.webfluxdemo.modelo.Persona;
import com.example.webfluxdemo.repo.PersonaRepoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private static final Logger log = LoggerFactory.getLogger(PersonaController.class);

    @Autowired
    private PersonaRepoImpl per;

    @GetMapping
    public Flux<Persona> listar(){
        return per.listar();
    }

    @GetMapping("/{id")
    public Mono<Persona> listarPorId(@PathVariable("id") Integer id){
        return per.listarId(id);
    }

    @PostMapping
    public Mono<Persona> registrar(@RequestBody Persona persona){
        return per.registrar(persona);
    }

    @PutMapping
    public Mono<Persona> modificar(@RequestBody Persona persona){
        return per.modificar(persona);
    }

    @DeleteMapping("/{id")
    public Mono<Void> eliminar(@PathVariable("id") Integer id){
        return per.eliminar(id);
    }
}
