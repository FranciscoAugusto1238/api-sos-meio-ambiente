package com.sos.sos.service;

import com.sos.sos.entidade.Usuario;
import com.sos.sos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAllByDataFimIsNull();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findByIdAndDataFimIsNull(id);
    }

    public Usuario salvar(Usuario usuario) {
        usuario.setDataInicio(new Date());
        usuario.setDataFim(null);
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
        return usuarioRepository.findByIdAndDataFimIsNull(id)
            .map(usuario -> {
                usuario.setNome(usuarioAtualizado.getNome());
                usuario.setCpf(usuarioAtualizado.getCpf());
                usuario.setUf(usuarioAtualizado.getUf());
                usuario.setMunicipio(usuarioAtualizado.getMunicipio());
                usuario.setDataNascimento(usuarioAtualizado.getDataNascimento());
                usuario.setAtivo(true);
                usuario.setSenha(usuarioAtualizado.getSenha());
                return usuarioRepository.save(usuario);
            })
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado ou inativo com ID: " + id));
    }

    public void deletar(Long id) {
        usuarioRepository.findByIdAndDataFimIsNull(id)
            .ifPresent(usuario -> {
                usuario.setDataFim(new Date());
                usuarioRepository.save(usuario);
            });
    }
    
    public Optional<Usuario> autenticarPorCpfESenha(Long cpf, String senha) {
        return usuarioRepository.findByCpfAndDataFimIsNull(cpf)
            .filter(usuario -> senha.equals(usuario.getSenha()));
    }

}
