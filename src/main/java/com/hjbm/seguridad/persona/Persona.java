package com.hjbm.seguridad.persona;

import com.hjbm.seguridad.empresa.Empresa;
import com.hjbm.seguridad.estado.Estado;
import com.hjbm.seguridad.ubicacion.Ubicacion;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

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

    public Persona() {
    }

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNroIdent() {
        return nroIdent;
    }

    public void setNroIdent(String nroIdent) {
        this.nroIdent = nroIdent;
    }

    public String getNroTelef() {
        return nroTelef;
    }

    public void setNroTelef(String nroTelef) {
        this.nroTelef = nroTelef;
    }

    public String getNroTelefInterno() {
        return nroTelefInterno;
    }

    public void setNroTelefInterno(String nroTelefInterno) {
        this.nroTelefInterno = nroTelefInterno;
    }

    public String getNroEmpleado() {
        return nroEmpleado;
    }

    public void setNroEmpleado(String nroEmpleado) {
        this.nroEmpleado = nroEmpleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", nroIdent='" + nroIdent + '\'' +
                ", nroTelef='" + nroTelef + '\'' +
                ", nroTelefInterno='" + nroTelefInterno + '\'' +
                ", nroEmpleado='" + nroEmpleado + '\'' +
                ", cargo='" + cargo + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
