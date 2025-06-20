package com.sos.sos.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sos.sos.entidade.Denuncia;
import com.sos.sos.entidade.Gerenciamento;
import com.sos.sos.repository.GerenciamentoRepository;

@Service
public class GerenciamentoService {

    @Autowired
    private GerenciamentoRepository gerenciamentoRepository;

    public Gerenciamento criarGerenciamentoInicial(Denuncia denuncia) {
        Gerenciamento gerenciamento = new Gerenciamento();
        gerenciamento.setDenuncia(denuncia);
        gerenciamento.setStatus("EM ANALISE");
        gerenciamento.setDataInicio(new Date());
        gerenciamento.setDataFim(null);
        return gerenciamentoRepository.save(gerenciamento);
    }

    public Gerenciamento atualizarGerenciamento(Long id, Gerenciamento gerenciamentoAtualizado) {
        return gerenciamentoRepository.findById(id)
            .map(gerenciamentoExistente -> {
                gerenciamentoExistente.setStatus(gerenciamentoAtualizado.getStatus());
                gerenciamentoExistente.setDataFim(gerenciamentoAtualizado.getDataFim());
                return gerenciamentoRepository.save(gerenciamentoExistente);
            })
            .orElseThrow(() -> new RuntimeException("Gerenciamento não encontrado com ID: " + id));
    }
    
    public List<Gerenciamento> listarTodos() {
        return gerenciamentoRepository.findAll();
    }
}
