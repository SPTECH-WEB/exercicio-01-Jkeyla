package com.validacao.fatura.controller;

import com.validacao.fatura.model.Fatura;
import com.validacao.fatura.repository.FaturaRepository;
import com.validacao.fatura.service.FaturaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faturas")
public class FaturaController {
    private final FaturaService faturaService;

    public FaturaController(FaturaService faturaService) {
        this.faturaService = faturaService;
    }

//    @PostMapping
//    public Fatura cadastrarFatura(@RequestBody Fatura fatura) {
//        return faturaService.cadastrarFatura(fatura);
//    }

    @PostMapping
    public ResponseEntity<Fatura> criarFatura(@Valid @RequestBody Fatura fatura){
        Fatura novaFatura = faturaService.cadastrarFatura(fatura);
        return ResponseEntity.ok(novaFatura);
    }

    @GetMapping
    public List<Fatura> listarFatura() {
        return faturaService.listarFatura();
    }
}
