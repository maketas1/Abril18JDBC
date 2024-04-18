package com.softtek.servicio;

import com.softtek.modelo.Tarea;

public interface ITareaServicio {
    Tarea crearTarea();

    Tarea crearTarea(Tarea t);

    void eliminarTarea(int id);
}
