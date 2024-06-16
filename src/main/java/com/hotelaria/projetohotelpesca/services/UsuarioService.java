package com.hotelaria.projetohotelpesca.services;

import com.hotelaria.projetohotelpesca.entities.Usuario;
import com.hotelaria.projetohotelpesca.exceptions.ResourceNotFoundException;
import com.hotelaria.projetohotelpesca.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + id));
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Integer id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuário não encontrado com ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }

    public Usuario update(Integer id, Usuario usuarioDetails) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + id));

        usuario.setNome(usuarioDetails.getNome());
        usuario.setCpf(usuarioDetails.getCpf());
        usuario.setRg(usuarioDetails.getRg());
        usuario.setEndereco(usuarioDetails.getEndereco());
        usuario.setTelefone(usuarioDetails.getTelefone());
        usuario.setCelular(usuarioDetails.getCelular());
        usuario.setUsuario(usuarioDetails.getUsuario());
        usuario.setSenha(usuarioDetails.getSenha());
        usuario.setDataNascimento(usuarioDetails.getDataNascimento());

        return usuarioRepository.save(usuario);
    }
}