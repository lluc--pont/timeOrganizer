package com.virianth.hibernate.modelo;

import javax.persistence.*;

@Entity
@Table(name = "TRABAJO")
public class Trabajo {

    @Id
    @Column(name = "ID_TRABAJO")
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "AUTOR_ID")
    private Empleado empleado;


    public Trabajo() {

    }

    public Trabajo(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
        empleado.addTrabajo(this);
    }

    @Override
    public String toString() {
        return "Trabajo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", empleado=" + empleado +
                '}';
    }
}
