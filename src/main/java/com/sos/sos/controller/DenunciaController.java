package com.sos.sos.controller;

import com.sos.sos.entidade.Denuncia;
import com.sos.sos.service.DenunciaService;
import com.sos.sos.vo.DenunciaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/denuncias")
public class DenunciaController {

    @Autowired
    private DenunciaService denunciaService;

    @GetMapping
    public ResponseEntity<List<DenunciaVO>> listarTodos() {
        List<DenunciaVO> lista = denunciaService.listarTodos()
                .stream()
                .map(DenunciaVO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DenunciaVO> buscarPorId(@PathVariable Long id) {
        return denunciaService.buscarPorId(id)
                .map(denuncia -> ResponseEntity.ok(new DenunciaVO(denuncia)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DenunciaVO> salvar(@RequestBody Denuncia denuncia) {
        Denuncia nova = denunciaService.salvar(denuncia);
        return ResponseEntity.ok(new DenunciaVO(nova));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DenunciaVO> atualizar(@PathVariable Long id, @RequestBody Denuncia denuncia) {
        try {
            Denuncia atualizada = denunciaService.atualizar(id, denuncia);
            return ResponseEntity.ok(new DenunciaVO(atualizada));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        denunciaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
    
    
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<DenunciaVO>> listarPorUsuario(@PathVariable("usuarioId") Long usuarioId) {        
    	List<DenunciaVO> lista = denunciaService.listarPorUsuario(usuarioId)
                .stream()
                .map(DenunciaVO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

}
