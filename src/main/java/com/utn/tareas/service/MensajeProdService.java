package com.utn.tareas.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod") //Solo se crea cuando el profile activo es "prod"
public class MensajeProdService implements MensajeService {

    @Override
    public void mostrarBienvenida() {
        System.out.println("Sistema de Tareas iniciado [MODO PRODUCCION]");
    }

    @Override
    public void mostrarDespedida() {
        System.out.println("Sistema finalizado correctamente.");
    }
}