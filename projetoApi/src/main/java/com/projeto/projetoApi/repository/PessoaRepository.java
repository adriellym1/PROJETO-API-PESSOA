package com.exemplo.universidade.repository;

import com.exemplo.universidade.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}