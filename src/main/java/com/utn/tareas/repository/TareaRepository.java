package com.utn.tareas.repository;

import com.utn.tareas.model.Tarea;
import com.utn.tareas.model.Prioridad;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TareaRepository {

    private final List<Tarea> tareas = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public TareaRepository() {
        // Inicializar con algunas tareas de ejemplo
        tareas.add(new Tarea(idGenerator.getAndIncrement(), "Estudiar Spring Boot", false, Prioridad.ALTA));
        tareas.add(new Tarea(idGenerator.getAndIncrement(), "Comprar mercaderia", true, Prioridad.MEDIA));
        tareas.add(new Tarea(idGenerator.getAndIncrement(), "Ir al gimnasio", false, Prioridad.BAJA));
    }

    public Tarea guardar(Tarea tarea) {
        tarea.setId(idGenerator.getAndIncrement());
        tareas.add(tarea);
        return tarea;
    }

    public List<Tarea> obtenerTodas() {
        return new ArrayList<>(tareas);
    }

    public Optional<Tarea> buscarPorId(Long id) {
        return tareas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    public void eliminarPorId(Long id) {
        tareas.removeIf(t -> t.getId().equals(id));
    }
}
