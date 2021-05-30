package com.hjbm.seguridad.grupo;

import com.hjbm.seguridad.empresa.Empresa;
import com.hjbm.seguridad.estado.Estado;
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
@Entity(name = "Grupo")
@Table(name = "grupo")
public class Grupo {

    @Id
    @SequenceGenerator(
            name = "grupo_sequence",
            sequenceName = "grupo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "grupo_sequence"
    )
    private Long id;

    @Column(name = "nombre",
            nullable = false
    )
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = false
    )
    @JoinColumn(
            name = "id_empresa",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "grupo_empresa_id_fk"
            )
    )
    private Empresa empresa;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = false
    )
    @JoinColumn(
            name = "id_sistema",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "grupo_sistema_id_fk"
            )
    )
    private Sistema sistema;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = false
    )
    @JoinColumn(
            name = "id_estado",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "grupo_estado_id_fk"
            )
    )
    private Estado estado;

    public Grupo(String nombre,
                 String descripcion,
                 Empresa empresa,
                 Sistema sistema,
                 Estado estado) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.empresa = empresa;
        this.sistema = sistema;
        this.estado = estado;
    }
}
