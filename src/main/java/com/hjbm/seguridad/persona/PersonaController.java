package com.hjbm.seguridad.persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/persona")
public class PersonaController {

    private final PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public List<Persona> getPersonas(){
        return personaService.getPersonas();
    }

    @PostMapping
    public void incluirPersona(@RequestBody Persona persona){
        personaService.incluirPersona(persona);
    }

    @DeleteMapping(path = "{personaId}")
    public void eliminarPersona(@PathVariable("personaId") Long personaId){
        personaService.eliminarPersona(personaId);
    }

    @PutMapping(path = "{personaId}")
    public void actualizarPersona(@PathVariable("personaId") Long personaId,
                                  @RequestParam(required = false) String nombre,
                                  @RequestParam(required = false) String email){
        personaService.actualizarPersona(personaId, nombre, email);
    }
}
