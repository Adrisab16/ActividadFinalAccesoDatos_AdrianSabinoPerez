package com.example.actividadfinalaccesodatos_adriansabinoperez.Controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class UIController {

    @GetMapping("/")
    fun mostrarPaginaPrincipal(): String {
        return "index"
    }

    @GetMapping("/submenu/{operacion}")
    fun mostrarSubMenu(@PathVariable operacion: String): String {
        return "submenus/" + operacion
    }
}
