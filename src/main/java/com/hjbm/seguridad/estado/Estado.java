package com.hjbm.seguridad.estado;

import com.hjbm.seguridad.empresa.Empresa;
import com.hjbm.seguridad.sistema.Sistema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity(name = "Estado")
@Table(name = "estado")
public class Estado {

    @Id
    @SequenceGenerator(
            name = "estado_sequence",
            sequenceName = "estado_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "estado_sequence"
    )
    private Integer id;

    @Column(
            name="nombre",
            nullable = false
    )
    private String nombre;

    @Column(
            name = "descripcion"
    )
    private String descripcion;

    public Estado(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

}
