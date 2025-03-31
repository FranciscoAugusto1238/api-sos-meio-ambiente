package com.sos.sos.vo;

import com.sos.sos.entidade.Denuncia;

public class DenunciaVO {

	private Long id;
	private UsuarioVO usuario;
    private GerenciamentoVO gerenciamento;
    private String descricao;
    private String arquivo;
    private Long geolocalizacao;

    public DenunciaVO(Denuncia denuncia) {
    	
    	this.id = denuncia.getId();
    	if(denuncia.getUsuario() != null) {
        	this.usuario = new UsuarioVO(denuncia.getUsuario());
    	}
    	if(denuncia.getGerenciamento() != null){
    		this.gerenciamento = new GerenciamentoVO(denuncia.getGerenciamento());
    	}
    	this.descricao = denuncia.getDescricao();
    	this.arquivo = denuncia.getArquivo();
    	this.geolocalizacao = denuncia.getGeolocalizacao();
    	
    }
    

}
