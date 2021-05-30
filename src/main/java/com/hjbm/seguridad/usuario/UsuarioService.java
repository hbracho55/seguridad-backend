package com.hjbm.seguridad.usuario;

import com.hjbm.seguridad.persona.Persona;
import com.hjbm.seguridad.persona.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }

    public void incluirUsuario(Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findPersonaByEmail(usuario.getEmail());
        if (usuarioOptional.isPresent()){
            throw new IllegalStateException("Email ya registrado!");
        }
        usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Long usuarioId) {
        boolean existe = usuarioRepository.existsById(usuarioId);
        if (!existe){
            throw new IllegalStateException("No existe la usuario con id: "+usuarioId);
        }
        usuarioRepository.deleteById(usuarioId);
    }

    @Transactional
    public void actualizarUsuario(Long usuarioId, String nombre, String email) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalStateException("No existe la usuario con id: "+ usuarioId));

        if (nombre != null && nombre.length() > 0 && !Objects.equals(usuario.getNombre(), nombre)){
            usuario.setNombre(nombre);

        }
/*
        if (email != null && email.length() > 0 && !Objects.equals(usuario.getEmail(), email)){
            Optional<Usuario> usuarioOpcional = usuarioRepository.findPersonaByEmail(email);
            if (usuarioOpcional.isPresent()){
                throw new IllegalStateException("Email ya registrado!");
            }
            usuario.setEmail(email);

        }

 */
    }
}
