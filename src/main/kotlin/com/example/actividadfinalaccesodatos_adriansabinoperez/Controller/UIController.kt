package com.example.actividadfinalaccesodatos_adriansabinoperez.Controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

/**
 * Controlador para manejar las solicitudes relacionadas con la interfaz de usuario.
 */
@Controller
class UIController {

    /**
     * Maneja las solicitudes GET para la ruta principal ("/") y devuelve el nombre de la plantilla "index".
     *
     * @return El nombre de la plantilla "index".
     */
    @GetMapping("/")
    fun mostrarPaginaPrincipal(): String {
        return "index"
    }

    /**
     * Maneja las solicitudes GET para rutas "/submenus/{operacion}" donde "{operacion}" es una variable de ruta.
     * Devuelve el nombre de la plantilla correspondiente al submenú especificado.
     *
     * @param operacion El nombre del submenú.
     * @return El nombre de la plantilla del submenú especificado.
     */
    @GetMapping("/submenus/{operacion}")
    fun mostrarSubMenu(@PathVariable operacion: String): String {
        return "submenus/$operacion"
    }
}
