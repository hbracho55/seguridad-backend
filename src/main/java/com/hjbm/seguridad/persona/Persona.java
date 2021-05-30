package com.hjbm.seguridad.persona;

import com.hjbm.seguridad.empresa.Empresa;
import com.hjbm.seguridad.estado.Estado;
import com.hjbm.seguridad.ubicacion.Ubicacion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity(name = "Persona")
@Table(name = "persona",
        uniqueConstraints = {
                @UniqueConstraint( name = "persona_email_unique", columnNames = "email")
        })
public class Persona {

    @Id
    @SequenceGenerator(
            name = "persona_sequence",
            sequenceName = "persona_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "persona_sequence"
    )
    private Long id;

    @Column(
            name = "nombre",
            nullable = false
    )
    private String nombre;

    @Column(
            name = "apellido",
            nullable = false
    )
    private String apellido;

    @Column(
            name = "email",
            nullable = false
    )
    private String email;

    @Column(
            name = "nro_ident"
    )
    private String nroIdent;

    @Column(
            name = "nro_telef"
    )
    private String nroTelef;

    @Column(
            name = "nro_telef_interno"
    )
    private String nroTelefInterno;

    @Column(
            name = "nro_empleado"
    )
    private String nroEmpleado;

    @Column(
            name = "cargo"
    )
    private String cargo;

    @Column(
            name = "direccion"
    )
    private String direccion;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = false
    )
    @JoinColumn(
            name = "id_ubicacion",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "persona_ubicacion_id_fk"
            )
    )
    private Ubicacion ubicacion;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = false
    )
    @JoinColumn(
            name = "id_empresa",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "persona_empresa_id_fk"
            )
    )
    private Empresa empresa;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = false
    )
    @JoinColumn(
            name = "id_estado",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "persona_estado_id_fk"
            )
    )
    private Estado estado;

    public Persona(String nombre,
                   String apellido,
                   String email,
                   String nroIdent,
                   String nroTelef,
                   String nroTelefInterno,
                   String nroEmpleado,
                   String cargo,
                   String direccion,
                   Empresa empresa,
                   Ubicacion ubicacion,
                   Estado estado) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nroIdent = nroIdent;
        this.nroTelef = nroTelef;
        this.nroTelefInterno = nroTelefInterno;
        this.nroEmpleado = nroEmpleado;
        this.cargo = cargo;
        this.direccion = direccion;
        this.empresa = empresa;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }

}
