package com.sos.sos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sos.sos.entidade.Gerenciamento;
import com.sos.sos.service.DenunciaService;
import com.sos.sos.service.GerenciamentoService;
import com.sos.sos.vo.GerenciamentoVO;

@RestController
@RequestMapping("/gerenciamentos")
public class GerenciamentoController {

    @Autowired
    private GerenciamentoService gerenciamentoService;

    @Autowired
    private DenunciaService denunciaService;
    
    @PutMapping("/{id}")
    public ResponseEntity<Gerenciamento> atualizarGerenciamento(@PathVariable("id") Long id, @RequestBody Gerenciamento gerenciamentoAtualizado) {
        Gerenciamento atualizado = gerenciamentoService.atualizarGerenciamento(id, gerenciamentoAtualizado);
        return ResponseEntity.ok(atualizado);
    }

    
    @GetMapping
    public ResponseEntity<List<GerenciamentoVO>> listarTodos() {
        List<Gerenciamento> lista = gerenciamentoService.listarTodos();
        List<GerenciamentoVO> listaVO = lista.stream()
                                             .map(GerenciamentoVO::new)
                                             .collect(Collectors.toList());
        return ResponseEntity.ok(listaVO);
    }

}
