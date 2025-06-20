package com.sos.sos.repository;

import com.sos.sos.entidade.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findAllByDataFimIsNull();

    Optional<Usuario> findByIdAndDataFimIsNull(Long id);
    
    Optional<Usuario> findByCpfAndDataFimIsNull(Long cpf);

}
