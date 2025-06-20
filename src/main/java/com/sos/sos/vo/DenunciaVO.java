package com.sos.sos.vo;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sos.sos.entidade.Denuncia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DenunciaVO {

    private Long id;
    private UsuarioVO usuario;
    private List<GerenciamentoResumoVO> gerenciamentos;
    private String descricao;
    private String arquivo;
    private String geolocalizacao;

    public DenunciaVO(Denuncia denuncia) {
        this.id = denuncia.getId();

        if (denuncia.getUsuario() != null) {
            this.usuario = new UsuarioVO(denuncia.getUsuario());
        }

        if (denuncia.getGerenciamentos() != null && !denuncia.getGerenciamentos().isEmpty()) {
            this.gerenciamentos = denuncia.getGerenciamentos()
                    .stream()
                    .map(GerenciamentoResumoVO::new)
                    .collect(Collectors.toList());
        }

        this.descricao = denuncia.getDescricao();
        this.arquivo = denuncia.getArquivo();
        this.geolocalizacao = denuncia.getGeolocalizacao();
    }

}
