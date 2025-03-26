package com.validacao.fatura.service;

import com.validacao.fatura.model.Fatura;
import com.validacao.fatura.repository.FaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaturaService {
    private final FaturaRepository faturaRepository;

    public FaturaService(FaturaRepository faturaRepository) {
        this.faturaRepository = faturaRepository;
    }

    public Fatura cadastrarFatura(Fatura fatura) {
        return faturaRepository.save(fatura);
    }

    public List<Fatura> listarFatura() {
        return faturaRepository.findAll();
    }
}
