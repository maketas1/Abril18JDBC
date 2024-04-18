package com.softtek.repo;

import com.softtek.modelo.Tarea;
import org.springframework.stereotype.Repository;

@Repository
public class TareaRepo implements ITareaRepo {
    @Override
    public Tarea obtenerTarea(){
        return new Tarea(100, "Descripcion de la tarea");
    }

    @Override
    public Tarea crearTarea(Tarea t) {
        t.setIdTarea(1);
        return t;
    }

    @Override
    public void eliminarTarea(int id) {
        //metodo para eliminar un objeto de la base de datos
    }
}
