package com.hjbm.seguridad.empresa;

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
@Entity(name = "Empresa")
@Table(name = "empresa")
public class Empresa {

    @Id
    @SequenceGenerator(
            name = "empresa_sequence",
            sequenceName = "empresa_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "empresa_sequence"
    )
    private Integer id;

    @Column(
            name = "nombre",
            nullable = false
    )
    private String nombre;

    @Column(
            name = "descripcion"
    )
    private String descripcion;

    @Column(
            name = "iniciales"
    )
    private String iniciales;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = false
    )
    @JoinColumn(
            name = "id_estado",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "empresa_estado_id_fk"
            )
    )
    private Estado estado;

    public Empresa(String nombre, String descripcion, String iniciales, Estado estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.iniciales = iniciales;
        this.estado = estado;
    }

}
