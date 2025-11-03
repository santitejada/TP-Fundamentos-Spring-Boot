package com.utn.tareas;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.service.MensajeService;
import com.utn.tareas.service.TareaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TareasApplication implements CommandLineRunner {

    private final TareaService tareaService;
    private final MensajeService mensajeService;

    public TareasApplication(TareaService tareaService, MensajeService mensajeService) {
        this.tareaService = tareaService;
        this.mensajeService = mensajeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TareasApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // Bienvenida
        mensajeService.mostrarBienvenida();

        // Configuración actual
        tareaService.mostrarConfiguracion();

        // Tareas iniciales
        System.out.println("\n TAREAS INICIALES:");
        tareaService.listarTodas().forEach(System.out::println);

        // Agregar nueva tarea
        System.out.println("\n Agregando nueva tarea...");
        tareaService.agregarTarea("Revisar trabajos practicos con envio pendiente", Prioridad.ALTA);

        //Pendientes
        System.out.println("\n TAREAS PENDIENTES:");
        tareaService.listarPendientes().forEach(System.out::println);

        //Completar tarea
        System.out.println("\n Marcando tarea con ID 1 como completada...");
        tareaService.marcarComoCompletada(1L);

        //Estadísticas
        System.out.println("\n ESTADISTICAS:");
        System.out.println(tareaService.obtenerEstadisticas());

        //Completadas
        System.out.println("\n TAREAS COMPLETADAS:");
        tareaService.listarCompletadas().forEach(System.out::println);

        //Despedida
        mensajeService.mostrarDespedida();
    }
}
