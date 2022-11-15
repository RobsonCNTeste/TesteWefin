package com.wefin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import com.wefin.application.groups.PessoaFisica;
import com.wefin.application.groups.PessoaJuridica;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Pessoa {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @NotBlank
    @Column(length = 14, nullable = false)
    @CPF(groups = PessoaFisica.class)
    @CNPJ(groups = PessoaJuridica.class)
    private String identificador;
    
    @Column(length = 50, nullable = false)
    @NotBlank
    private String nome;
    
    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoIdentificador tipoIdentificador;

    public Pessoa(String identificador, String nome) {
		this.identificador = identificador;
		this.nome = nome;
	}
    
}
