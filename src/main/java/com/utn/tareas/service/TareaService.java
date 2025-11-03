package com.utn.tareas.service;

import com.utn.tareas.model.Tarea;
import com.utn.tareas.model.Prioridad;
import com.utn.tareas.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    // Inyección de propiedades desde application.properties
    @Value("${app.nombre}")
    private String nombreApp;

    @Value("${app.max-tareas}")
    private int maxTareas;

    @Value("${app.mostrar-estadisticas}")
    private boolean mostrarEstadisticas;

    // Inyección de dependencias por constructor
    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    // Agregar nueva tarea (validando límite máximo)
    public Tarea agregarTarea(String descripcion, Prioridad prioridad) {
        if (tareaRepository.obtenerTodas().size() >= maxTareas) {
            System.out.println("No se pueden agregar mas tareas. Limite alcanzado (" + maxTareas + ").");
            return null;
        }

        Tarea tarea = new Tarea();
        tarea.setDescripcion(descripcion);
        tarea.setPrioridad(prioridad);
        tarea.setCompletada(false);
        return tareaRepository.guardar(tarea);
    }

    // Listar todas las tareas
    public List<Tarea> listarTodas() {
        return tareaRepository.obtenerTodas();
    }

    // Listar tareas pendientes
    public List<Tarea> listarPendientes() {
        return tareaRepository.obtenerTodas().stream()
                .filter(t -> !t.isCompletada())
                .collect(Collectors.toList());
    }

    // Listar tareas completadas
    public List<Tarea> listarCompletadas() {
        return tareaRepository.obtenerTodas().stream()
                .filter(Tarea::isCompletada)
                .collect(Collectors.toList());
    }

    // Marcar una tarea como completada
    public void marcarComoCompletada(Long id) {
        tareaRepository.buscarPorId(id).ifPresent(t -> t.setCompletada(true));
    }

    // Obtener estadísticas (si está activado)
    public String obtenerEstadisticas() {
        if (!mostrarEstadisticas) {
            return "Las estadisticas estan desactivadas.";
        }

        long total = tareaRepository.obtenerTodas().size();
        long completadas = tareaRepository.obtenerTodas().stream().filter(Tarea::isCompletada).count();
        long pendientes = total - completadas;

        return String.format("Total: %d |  Completadas: %d |  Pendientes: %d",
                total, completadas, pendientes);
    }

    // Mostrar propiedades de configuración
    public void mostrarConfiguracion() {
        System.out.println("=== CONFIGURACION ACTUAL ===");
        System.out.println("Nombre: " + nombreApp);
        System.out.println("Maximo de tareas: " + maxTareas);
        System.out.println("Mostrar estadisticas: " + mostrarEstadisticas);
        System.out.println("============================");
    }
}
