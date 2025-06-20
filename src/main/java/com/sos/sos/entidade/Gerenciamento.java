package com.sos.sos.entidade;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "gerenciamento_sos")
public class Gerenciamento {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq_gerenciamento")
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "seq_denuncia")
	private Denuncia denuncia;
	
	@Column(name = "status")
    private String status;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_inicio")
    private Date dataInicio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_fim")
    private Date dataFim;
	
}
