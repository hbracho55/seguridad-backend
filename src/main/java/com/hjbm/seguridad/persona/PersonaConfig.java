package com.hjbm.seguridad.persona;

import com.hjbm.seguridad.empresa.Empresa;
import com.hjbm.seguridad.estado.Estado;
import com.hjbm.seguridad.ubicacion.Ubicacion;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PersonaConfig {

    @Bean
    CommandLineRunner commandLineRunner(PersonaRepository personaRepository){
        return args -> {
            Estado activo = new Estado("Activo", "activo en el sistema");
            Empresa cenco = new Empresa("Cencosud","Cencosud",null,activo);
            Ubicacion florida = new Ubicacion("Edif Florida", cenco,activo);

            Persona hector = new Persona(
                    "Hector",
                    "Bracho",
                    "hbracho55@hotmail.com",
                    "25516031-1",
                    "983764365",
                    "2531",
                    null,
                    "SAP System engineer",
                    "Carmen 319",
                    cenco,
                    florida,
                    activo
            );

            //        LocalDate.of(1979, Month.MAY, 9)
            //
            Persona marce = new Persona(
                    "Marcela",
                    "Bracho",
                    "marcelita.bracho@gmail.com",
                    "25654750-3",
                    "983453341",
                    null,
                    null,
                    "Estudiante",
                    "Carmen 319",
                    cenco,
                    florida,
                    activo
            );


            personaRepository.saveAll(List.of(hector, marce));

            System.out.println(hector);
        };
    }
}
