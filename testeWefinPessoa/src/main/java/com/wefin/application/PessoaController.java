package com.wefin.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("pessoas")
@RequiredArgsConstructor
@Slf4j
public class PessoaController {

	@GetMapping("check")
    public String status(){
        log.info("Verificando o microserviço de pessoas");
        return "Microserviço de pessoas funcionando OK!";
    }

	
}
