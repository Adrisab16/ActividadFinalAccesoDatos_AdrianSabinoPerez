package com.example.actividadfinalaccesodatos_adriansabinoperez

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Clase de aplicación principal de Spring Boot.
 */

@SpringBootApplication
class Application

/**
 * Función principal que inicia la aplicación Spring Boot.
 *
 * @param args Argumentos de línea de comandos proporcionados al iniciar la aplicación.
 */

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}