package com.virianth.hibernate.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity //javax.persistence
@Table(name = "EMPLEADO")
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "COD_EMPLEADO")
    private Long codigo;

    @Column(name = "APELLIDOS")
    private String apellidos;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "FECHA_NACIMIENTO")
    private Date fechaNacimiento;

    @OneToOne(cascade = {CascadeType.ALL}) //orphanRemoval = true
    @JoinColumn(name = "ID_DIRECCION")
    private Direccion direccion;

    @OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY)
    //@OneToMany(mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<Trabajo> trabajos = new ArrayList<>();

    public Empleado() {

    }

    public Empleado(Long codigo, String apellidos, String nombre, Date fechaNacimiento) {
        this.codigo = codigo;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
        direccion.setEmpleado(this);
    }

    public List<Trabajo> getTrabajos() {
        return trabajos;
    }

    public void setTrabajos(List<Trabajo> trabajos) {
        this.trabajos = trabajos;
    }

    public void addTrabajo(Trabajo trabajo) {
        this.trabajos.add(trabajo);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "codigo=" + codigo +
                ", apellidos='" + apellidos + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", direccion=" + direccion +
                ", trabajos=" + trabajos.size() +
                '}';
    }
}
