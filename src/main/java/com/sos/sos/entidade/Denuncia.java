package com.sos.sos.entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "denuncia_sos")
public class Denuncia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq_denuncia")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "seq_usuario")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "denuncia")
	private List<Gerenciamento> gerenciamentos = new ArrayList<>();
	
	@Lob
	@Column(name = "descricao")
    private String descricao;
	
	@Lob
	@Column(name = "arquivo_base_64")
    private String arquivo;
	
	@Column(name = "geolocalizacao")
    private String  geolocalizacao;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_inicio")
    private Date dataInicio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_fim")
    private Date dataFim;
	
	
}
