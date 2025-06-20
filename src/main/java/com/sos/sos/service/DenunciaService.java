package com.sos.sos.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sos.sos.entidade.Denuncia;
import com.sos.sos.repository.DenunciaRepository;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository denunciaRepository;
    
    @Autowired
    private GerenciamentoService gerenciamentoService;

    public List<Denuncia> listarTodos() {
        return denunciaRepository.findAllByDataFimIsNull();
    }

    public Optional<Denuncia> buscarPorId(Long id) {
        return denunciaRepository.findByIdAndDataFimIsNull(id);
    }

    public Denuncia salvar(Denuncia denuncia) {
        denuncia.setDataInicio(new Date());
        denuncia.setDataFim(null);
        Denuncia denunciaSalva = denunciaRepository.save(denuncia);

        gerenciamentoService.criarGerenciamentoInicial(denunciaSalva);

        return denunciaSalva;
    }

    public Denuncia atualizar(Long id, Denuncia nova) {
        return denunciaRepository.findByIdAndDataFimIsNull(id)
                .map(denuncia -> {
                    denuncia.setUsuario(nova.getUsuario());
                    denuncia.setDescricao(nova.getDescricao());
                    denuncia.setArquivo(nova.getArquivo());
                    denuncia.setGeolocalizacao(nova.getGeolocalizacao());
                    return denunciaRepository.save(denuncia);
                })
                .orElseThrow(() -> new RuntimeException("Denúncia não encontrada ou inativa com ID: " + id));
    }

    public void deletar(Long id) {
        denunciaRepository.findByIdAndDataFimIsNull(id)
                .ifPresent(denuncia -> {
                    denuncia.setDataFim(new Date());
                    denunciaRepository.save(denuncia);
                });
    }
    
    @Transactional(readOnly = true)
    public List<Denuncia> listarPorUsuario(Long usuarioId) {
        return denunciaRepository.findByUsuarioId(usuarioId);
    }
}
