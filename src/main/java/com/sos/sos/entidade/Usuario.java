package com.sos.sos.entidade;


import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "usurio_sos")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq_usuario")
    private Long id;
    
    @OneToMany(mappedBy = "usuario")
    private List<Denuncia> denuncias;
    
    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private Long cpf;
    
    @Column(name = "UF")
    private String uf;
    
    @Column(name = "municipio")
    private String municipio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    
    @Column(name = "ativo")
    private Boolean ativo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_inicio")
    private Date dataInicio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_fim")
    private Date dataFim;
    
    @Column(name = "senha")
    private String senha;
}