package com.hjbm.seguridad.persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> getPersonas(){
        return personaRepository.findAll();
    }

    public void incluirPersona(Persona persona) {
        Optional<Persona> personaOptional = personaRepository.findPersonaByEmail(persona.getEmail());
        if (personaOptional.isPresent()){
            throw new IllegalStateException("Email ya registrado!");
        }
        personaRepository.save(persona);
    }

    public void eliminarPersona(Long personaId) {
        boolean existe = personaRepository.existsById(personaId);
        if (!existe){
            throw new IllegalStateException("No existe la persona con id: "+personaId);
        }
        personaRepository.deleteById(personaId);
    }

    @Transactional
    public void actualizarPersona(Long personaId, String nombre, String email) {

        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new IllegalStateException("No existe la persona con id: "+ personaId));

        if (nombre != null && nombre.length() > 0 && !Objects.equals(persona.getNombre(), nombre)){
            persona.setNombre(nombre);

        }

        if (email != null && email.length() > 0 && !Objects.equals(persona.getEmail(), email)){
            Optional<Persona> personaOpcional = personaRepository.findPersonaByEmail(email);
            if (personaOpcional.isPresent()){
                throw new IllegalStateException("Email ya registrado!");
            }
            persona.setEmail(email);

        }
    }
}
