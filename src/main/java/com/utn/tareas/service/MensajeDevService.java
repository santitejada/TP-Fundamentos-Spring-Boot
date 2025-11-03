package com.utn.tareas.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev") //Solo se crea cuando el profile activo es "dev"
public class MensajeDevService implements MensajeService {

    @Override
    public void mostrarBienvenida() {
        System.out.println("Bienvenido al sistema de tareas [ENTORNO DESARROLLO]");
        System.out.println("Aqui podras probar libremente sin afectar produccion.");
    }

    @Override
    public void mostrarDespedida() {
        System.out.println("Finalizando sesion de desarrollo.");
    }
}