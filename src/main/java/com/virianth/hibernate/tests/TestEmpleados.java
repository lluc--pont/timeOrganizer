package com.virianth.hibernate.tests;

import com.virianth.hibernate.modelo.Direccion;
import com.virianth.hibernate.modelo.Empleado;
import com.virianth.hibernate.modelo.Trabajo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Time;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class TestEmpleados {

    //@PersistenceContext(unitName = "Persistencia") Java WEB con containers
    private static EntityManager manager;

    private static EntityManagerFactory enf = Persistence.createEntityManagerFactory("Persistencia");

    public static void main(String[] args) {
        //gestor persistencia
        //enf = Persistence.createEntityManagerFactory("Persistencia");
        //List<Empleado> empleados = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
        //System.out.println("En esta nueva base de datos hay " + empleados.size() + " empleados.");

        //manager.merge() //recargar datos de una entity detached (sin hacer el find)
        insertInicial();

        imprimirTodo();

    }

    private static void insertInicial() {
        manager = enf.createEntityManager();

        Empleado e = new Empleado(10L, "Perez", "Pepito", new GregorianCalendar(1979, 6, 6).getTime());
        Direccion d = new Direccion(15L, "Calle Falsa 123", "Springfield", "Springfield", "EEUU");
        Trabajo t = new Trabajo(20L, "Hello Job");
        e.setDireccion(d);
        t.setEmpleado(e);

        manager.getTransaction().begin();
        //manager.persist(d); //si no se usa el @OneToOne(cascade = {CascadeType.ALL}), "e" no puede hacer el persist porque "d" no existe
        //manager.persist(e);
        manager.persist(t);
        e.setApellidos("Lopez");
        manager.getTransaction().commit();

        Empleado e10 = manager.find(Empleado.class,10L);
        e10.setNombre("David");


        Trabajo t1 = new Trabajo(1L, "T1");
        Trabajo t2 = new Trabajo(2L, "T2");
        Trabajo t3 = new Trabajo(3L, "T3");
        Trabajo t4 = new Trabajo(4L, "T4");
        Trabajo t5 = new Trabajo(5L, "T5");
        Empleado e1 = new Empleado(1L, "SecondName1", "Name1", new Date(System.currentTimeMillis() - 1*5*365*24*3600*1000));
        Empleado e2 = new Empleado(2L, "SecondName2", "Name2", new Date(System.currentTimeMillis() - 2*5*365*24*3600*1000));
        Empleado e3 = new Empleado(3L, "SecondName3", "Name3", new Date(System.currentTimeMillis() - 3*5*365*24*3600*1000));

        t1.setEmpleado(e1);
        t2.setEmpleado(e2);
        //t3.setEmpleado(e3);
        t4.setEmpleado(e1);
        t5.setEmpleado(e1);


        manager.getTransaction().begin();
        manager.persist(t1);
        manager.persist(t2);
        manager.persist(t3);
        manager.persist(t4);
        manager.persist(t5);
        manager.getTransaction().commit();


        manager.close();

    }

    private static void imprimirTodo() {
        //List<Empleado> emps = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
        //System.out.println("En la base de datos hay " + emps.size() + " empleados.");
        //for(Empleado emp : emps) {
        //    System.out.println(emp.toString());
        //}

        manager = enf.createEntityManager();
        List<Trabajo> tbjs = manager.createQuery("FROM Trabajo").getResultList();

        System.out.println("En la base de datos hay " + tbjs.size() + " trabajos.");
        for(Trabajo tbj : tbjs) {
            System.out.println(tbj.toString());
        }


        Empleado e1 = (Empleado) manager.createQuery("FROM Empleado WHERE id = 1L").getSingleResult();
        //tbjs.size(); // eager del elemento para poder despues escribirlos
        //List<Trabajo> e1Tbjs = e1.getTrabajos();
        //e1Tbjs.size(); // eager del elemento para poder despues escribirlos
        manager.close();


        System.out.println("El empleado E1 tiene " + e1.getTrabajos().size() + " trabajos.");
        for(Trabajo tbj : e1.getTrabajos()) {
            System.out.println(tbj.getNombre());
        }

    }
}
