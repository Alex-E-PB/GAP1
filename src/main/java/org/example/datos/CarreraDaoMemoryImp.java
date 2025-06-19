package org.example.datos;

import org.example.datos.CarreraDAO;
import org.example.dominio.Carrera;

public class CarreraDaoMemoryImp implements CarreraDAO {
    private Carrera[] carreras;
    private int contador;

    public CarreraDaoMemoryImp() {
        this.carreras = new Carrera[5]; // tamaño inicial
        this.contador = 0;
    }

    private void redimensionar() {
        Carrera[] nuevo = new Carrera[carreras.length * 2];
        System.arraycopy(carreras, 0, nuevo, 0, carreras.length);
        carreras = nuevo;
    }

    @Override
    public boolean crear(Carrera carrera) {
        if (buscarPorId(carrera.getID_CARRERA()) != null) return false;
        if (contador == carreras.length) redimensionar();
        carreras[contador++] = carrera;
        return true;
    }

    @Override
    public boolean editar(Carrera carrera) {
        for (int i = 0; i < contador; i++) {
            if (carreras[i].getID_CARRERA().equals(carrera.getID_CARRERA())) {
                carreras[i].setCarrera(carrera.getCarrera());
                carreras[i].setDuracion(carrera.getDuracion());
                carreras[i].setTitulo(carrera.getTitulo());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(String idCarrera) {
        for (int i = 0; i < contador; i++) {
            if (carreras[i].getID_CARRERA().equals(idCarrera)) {
                for (int j = i; j < contador - 1; j++) {
                    carreras[j] = carreras[j + 1];
                }
                carreras[--contador] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Carrera buscarPorId(String idCarrera) {
        for (int i = 0; i < contador; i++) {
            if (carreras[i].getID_CARRERA().equals(idCarrera)) {
                return carreras[i];
            }
        }
        return null;
    }

    @Override
    public Carrera[] listar() {
        Carrera[] copia = new Carrera[contador];
        System.arraycopy(carreras, 0, copia, 0, contador);
        return copia;
    }
}
