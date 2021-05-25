package com.hjbm.seguridad.unidad;

import com.hjbm.seguridad.empresa.Empresa;
import com.hjbm.seguridad.estado.Estado;
import com.hjbm.seguridad.jerarquia.Jerarquia;
import com.hjbm.seguridad.ubicacion.Ubicacion;

import javax.persistence.*;

@Entity(name = "Unidad")
@Table(name = "unidad")
public class Unidad {

    @Id
    @SequenceGenerator(
            name = "unidad_sequence",
            sequenceName = "unidad_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "unidad_sequence"
    )
    private Long id;

    @Column(
            name = "nombre",
            nullable = false
    )
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "id_padre")
    private Long idPadre;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = false
    )
    @JoinColumn(
            name = "id_jerarquia",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "unidad_jerarquia_id_fk"
            )
    )
    private Jerarquia jerarquia;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = false
    )
    @JoinColumn(
            name = "id_ubicacion",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "unidad_ubicacion_id_fk"
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
                    name = "unidad_empresa_id_fk"
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
                    name = "unidad_estado_id_fk"
            )
    )
    private Estado estado;

    public Unidad() {
    }

    public Unidad(String nombre,
                  String descripcion,
                  Long idPadre,
                  Jerarquia jerarquia,
                  Ubicacion ubicacion,
                  Empresa empresa,
                  Estado estado) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idPadre = idPadre;
        this.jerarquia = jerarquia;
        this.ubicacion = ubicacion;
        this.empresa = empresa;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Long idPadre) {
        this.idPadre = idPadre;
    }

    public Jerarquia getJerarquia() {
        return jerarquia;
    }

    public void setJerarquia(Jerarquia jerarquia) {
        this.jerarquia = jerarquia;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Unidad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", idPadre=" + idPadre +
                '}';
    }
}
