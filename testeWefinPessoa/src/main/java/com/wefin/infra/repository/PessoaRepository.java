package com.wefin.infra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wefin.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
;	Optional<Pessoa> findByIdentificador(String identificador);
}
