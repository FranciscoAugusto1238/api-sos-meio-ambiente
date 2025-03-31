package com.sos.sos.vo;

import com.sos.sos.entidade.Gerenciamento;

public class GerenciamentoVO {
	
    private Long id;
    private String status;

	public GerenciamentoVO(Gerenciamento gerenciamento){
		this.id = gerenciamento.getId();
		this.status = gerenciamento.getStatus();
	}

}
