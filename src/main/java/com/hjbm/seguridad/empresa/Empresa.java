package com.hjbm.seguridad.empresa;

import com.hjbm.seguridad.estado.Estado;
import com.hjbm.seguridad.sistema.Sistema;

import javax.persistence.*;

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

    public Empresa() {

    }

    public Empresa(String nombre, String descripcion, String iniciales, Estado estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.iniciales = iniciales;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIniciales() {
        return iniciales;
    }

    public void setIniciales(String iniciales) {
        this.iniciales = iniciales;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", iniciales='" + iniciales + '\'' +
                '}';
    }
}
