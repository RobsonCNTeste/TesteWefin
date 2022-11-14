package com.wefin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Pessoa {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column(length = 14, nullable = false)
    private String identificador;
    
    @Column(length = 50, nullable = false)
    private String nome;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoIdentificador tipoIdentificador;

    public Pessoa(String identificador, String nome) {
		this.identificador = identificador;
		this.nome = nome;
	}
    
}
