package com.hjbm.seguridad.ubicacion;

import com.hjbm.seguridad.empresa.Empresa;
import com.hjbm.seguridad.estado.Estado;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity(name = "Ubicacion")
@Table(name = "ubicacion")
public class Ubicacion {

    @Id
    @SequenceGenerator(
            name = "ubicacion_sequence",
            sequenceName = "ubicacion_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ubicacion_sequence"
    )
    private Long id;

    @Column(
            name = "nombre"
    )
    private String nombre;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = false
    )
    @JoinColumn(
            name = "id_empresa",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "ubicacion_empresa_id_fk"
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
                    name = "ubicacion_estado_id_fk"
            )
    )
    private Estado estado;

    public Ubicacion(String nombre, Empresa empresa, Estado estado) {
        this.nombre = nombre;
        this.empresa = empresa;
        this.estado = estado;
    }

}
