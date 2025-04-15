package com.exemplo.universidade.controller;

import com.exemplo.universidade.dto.PessoaDTO;
import com.exemplo.universidade.model.Pessoa;
import com.exemplo.universidade.repository.PessoaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
@Validated
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<Pessoa> criar(@RequestBody @Valid PessoaDTO dto) {
        Pessoa pessoa = mapper.map(dto, Pessoa.class);
        return ResponseEntity.ok(repository.save(pessoa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}