package com.hjbm.seguridad.usuario;

import com.hjbm.seguridad.persona.Persona;
import com.hjbm.seguridad.persona.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> getUsuarios(){
        return usuarioService.getUsuarios();
    }

    @PostMapping
    public void incluirUsuario(@RequestBody Usuario usuario){
        usuarioService.incluirUsuario(usuario);
    }

    @DeleteMapping(path = "{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
        usuarioService.eliminarUsuario(usuarioId);
    }

    @PutMapping(path = "{usuarioId}")
    public void actualizarUsuario(@PathVariable("usuarioId") Long usuarioId,
                                  @RequestParam(required = false) String nombre,
                                  @RequestParam(required = false) String clave){
        usuarioService.actualizarUsuario(usuarioId, nombre, clave);
    }
}
