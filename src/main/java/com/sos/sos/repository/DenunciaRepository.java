package com.sos.sos.repository;

import com.sos.sos.entidade.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {

    List<Denuncia> findAllByDataFimIsNull();

    List<Denuncia> findByUsuarioId(Long usuarioId);
    
    Optional<Denuncia> findByIdAndDataFimIsNull(Long id);
}
