package com.sos.sos.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sos.sos.entidade.Gerenciamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GerenciamentoResumoVO {

    private Long id;
    private String status;

    public GerenciamentoResumoVO(Gerenciamento gerenciamento) {
        this.id = gerenciamento.getId();
        this.status = gerenciamento.getStatus();
    }
}
