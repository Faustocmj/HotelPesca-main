package com.hotelaria.projetohotelpesca.services;

import com.hotelaria.projetohotelpesca.entities.Usuario;
import com.hotelaria.projetohotelpesca.exceptions.ResourceNotFoundException;
import com.hotelaria.projetohotelpesca.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + id));
    }

    public Usuario save(Usuario usuario) {
        // Verificar se o usuário já existe pelo campo 'usuario'
        if (usuarioRepository.existsByUsuario(usuario.getUsuario())) {
            return null; // Retornar null para indicar que o usuário já existe
        }
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuário não encontrado com ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> pesquisarUsuarios(String keyword) {
        return usuarioRepository.findByNomeContainingOrCpfContaining(keyword, keyword);
    }

    public boolean authenticate(String codusuario, String senha) {
        Usuario usuario = usuarioRepository.findByUsuario(codusuario);
        return usuario!= null && usuario.getSenha().equals(senha);
    }


    public Usuario update(Long id, Usuario usuarioDetails) {
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