package com.hjbm.seguridad.usuario;

import com.hjbm.seguridad.empresa.Empresa;
import com.hjbm.seguridad.estado.Estado;
import com.hjbm.seguridad.persona.Persona;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity(name = "Usuario")
@Table(name = "usuario",
        uniqueConstraints = {
                @UniqueConstraint( name = "usuario_nombre_unique", columnNames = "nombre")
        })
public class Usuario {

    @Id
    @SequenceGenerator(
            name = "usuario_sequence",
            sequenceName = "usuario_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "usuario_sequence"
    )
    private Long id;

    @Column(
            name = "nombre",
            nullable = false
    )
    private String nombre;

    @Column(
            name = "clave",
            nullable = false
    )
    private String clave;

    @Column(
            name = "pregunta_secreta",
            nullable = false
    )
    private String preguntaSecreta;

    @Column(
            name = "respuesta_secreta",
            nullable = false
    )
    private String respuestaSecreta;

    @Column(
            name = "expira_clave",
            nullable = false
    )
    private Boolean expiraClave;

    @Column(
            name = "fecha_expiracion",
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDate fechaExpiracion;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = false
    )
    @JoinColumn(
            name = "id_persona",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "usuario_persona_id_fk"
            )
    )
    private Persona persona;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = false
    )
    @JoinColumn(
            name = "id_empresa",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "usuario_empresa_id_fk"
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
                    name = "usuario_estado_id_fk"
            )
    )
    private Estado estado;

    public Usuario(String nombre,
                   String clave,
                   String preguntaSecreta,
                   String respuestaSecreta,
                   Boolean expiraClave,
                   LocalDate fechaExpiracion,
                   Persona persona,
                   Empresa empresa,
                   Estado estado) {

        this.nombre = nombre;
        this.clave = clave;
        this.preguntaSecreta = preguntaSecreta;
        this.respuestaSecreta = respuestaSecreta;
        this.expiraClave = expiraClave;
        this.fechaExpiracion = fechaExpiracion;
        this.persona = persona;
        this.empresa = empresa;
        this.estado = estado;
    }

}
