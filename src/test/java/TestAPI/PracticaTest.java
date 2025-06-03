package TestAPI;
import org.example.dominio.Practica;
import org.junit.jupiter.api.Test;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class PracticaTest {

    @org.junit.jupiter.api.Test
    void getIdPractica() {
        Practica practica = new Practica();
        practica.setIdPractica("");
        assertEquals("",practica.getIdPractica());
    }

    @org.junit.jupiter.api.Test
    void setIdPractica() {
        Practica practica = new Practica();
        practica.setIdPractica("");
        assertEquals("",practica.getIdPractica());

    }

    @org.junit.jupiter.api.Test
    void getEmpresa() {
        Practica practica = new Practica();
        practica.setEmpresa("Banco Pichincha");
        assertEquals("Banco Pichincha",practica.getEmpresa());
    }

    @org.junit.jupiter.api.Test
    void setEmpresa() {
        Practica practica = new Practica();
        practica.setEmpresa("Banco Pichincha");
        assertEquals("Banco Pichincha",practica.getEmpresa());
    }

    @org.junit.jupiter.api.Test
    void getPuesto() {
        Practica practica = new Practica();
        practica.setPuesto("Pasante");
        assertEquals("Pasante",practica.getPuesto());
    }

    @org.junit.jupiter.api.Test
    void setPuesto() {
        Practica practica = new Practica();
        practica.setPuesto("Pasante");
        assertEquals("Pasante",practica.getPuesto());
    }

    @org.junit.jupiter.api.Test
    void getUbicación() {
        Practica practica = new Practica();
        practica.setUbicacion("Panamericana Norte km 11, 1 2 y, Quito 170133");
        assertEquals("Panamericana Norte km 11, 1 2 y, Quito 170133",practica.getUbicacion());
    }

    @org.junit.jupiter.api.Test
    void setUbicación() {
        Practica practica = new Practica();
        practica.setUbicacion("Panamericana Norte km 11, 1 2 y, Quito 170133");
        assertEquals("Panamericana Norte km 11, 1 2 y, Quito 170133",practica.getUbicacion());
    }

    @org.junit.jupiter.api.Test
    void getFechaInicio() {
        Practica practica = new Practica();
        Date fechaInicio = new Date();
        practica.setFechaInicio(fechaInicio);
        assertEquals(fechaInicio,practica.getFechaInicio());
    }

    @org.junit.jupiter.api.Test
    void setFechaInicio() {
        Practica practica = new Practica();
        Date fechaInicio = new Date();
        practica.setFechaInicio(fechaInicio);
        assertEquals(fechaInicio,practica.getFechaInicio());
    }

    @org.junit.jupiter.api.Test
    void getFechaFin() {
        Practica practica = new Practica();
        Date fechaFin = new Date();
        practica.setFechaFin(fechaFin);
        assertEquals(fechaFin,practica.getFechaFin());
    }

    @org.junit.jupiter.api.Test
    void setFechaFin() {
        Practica practica = new Practica();
        Date fechaFin = new Date();
        practica.setFechaFin(fechaFin);
        assertEquals(fechaFin,practica.getFechaFin());
    }

    @Test
    void getDescripcion() {
        Practica practica = new Practica();
        practica.setDescripcion("Práctica profesional en empresa de software para el desarrollo de una aplicación web con tecnologías Java y Spring Boot.");
        assertEquals("Práctica profesional en empresa de software para el desarrollo de una aplicación web con tecnologías Java y Spring Boot.",practica.getDescripcion());
    }

    @Test
    void setDescripcion() {
        Practica practica = new Practica();
        practica.setDescripcion("Práctica profesional en empresa de software para el desarrollo de una aplicación web con tecnologías Java y Spring Boot.");
        assertEquals("Práctica profesional en empresa de software para el desarrollo de una aplicación web con tecnologías Java y Spring Boot.",practica.getDescripcion());
    }

    @Test
    void getRequisitos() {
        Practica practica = new Practica();
        practica.setRequisitos("Requisitos para postularse:\n" +
                "- Estar matriculado en al menos el 6.º semestre\n" +
                "- Haber aprobado Programación II y Base de Datos\n" +
                "- Conocimientos básicos de Java y Git\n" +
                "- Enviar CV actualizado en PDF");
        assertEquals("Requisitos para postularse:\n" +
                "- Estar matriculado en al menos el 6.º semestre\n" +
                "- Haber aprobado Programación II y Base de Datos\n" +
                "- Conocimientos básicos de Java y Git\n" +
                "- Enviar CV actualizado en PDF",practica.getRequisitos());
    }

    @Test
    void setRequisitos() {
        Practica practica = new Practica();
        practica.setRequisitos("Requisitos para postularse:\n" +
                "- Estar matriculado en al menos el 6.º semestre\n" +
                "- Haber aprobado Programación II y Base de Datos\n" +
                "- Conocimientos básicos de Java y Git\n" +
                "- Enviar CV actualizado en PDF");
        assertEquals("Requisitos para postularse:\n" +
                "- Estar matriculado en al menos el 6.º semestre\n" +
                "- Haber aprobado Programación II y Base de Datos\n" +
                "- Conocimientos básicos de Java y Git\n" +
                "- Enviar CV actualizado en PDF",practica.getRequisitos());
    }

    @Test
    void getDuracion() {
        Practica practica = new Practica();
        practica.setDuracion(4);
        assertEquals(4,practica.getDuracion());
    }

    @Test
    void setDuracion() {
        Practica practica = new Practica();
        practica.setDuracion(4);
        assertEquals(4,practica.getDuracion());
    }
}
