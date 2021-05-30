package com.hjbm.seguridad.jerarquia;

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
@Entity(name = "Jerarquia")
@Table(name = "jerarquia")
public class Jerarquia {

    @Id
    @SequenceGenerator(
            name = "jerarquia_sequence",
            sequenceName = "jerarquia_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "jerarquia_sequence"
    )
    private Integer id;

    @Column(
            name = "nombre",
            nullable = false
    )
    private String nombre;

    @Column(name = "nivel")
    private Integer nivel;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = false
    )
    @JoinColumn(
            name = "id_empresa",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "jerarquia_empresa_id_fk"
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
                    name = "jerarquia_estado_id_fk"
            )
    )
    private Estado estado;

    public Jerarquia(String nombre, Integer nivel, Empresa empresa, Estado estado) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.empresa = empresa;
        this.estado = estado;
    }

}
