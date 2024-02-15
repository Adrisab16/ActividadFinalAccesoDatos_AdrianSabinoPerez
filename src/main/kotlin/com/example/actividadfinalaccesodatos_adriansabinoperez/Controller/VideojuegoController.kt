package com.example.actividadfinalaccesodatos_adriansabinoperez.Controller

import com.example.actividadfinalaccesodatos_adriansabinoperez.Entity.Videojuego
import com.example.actividadfinalaccesodatos_adriansabinoperez.Service.VideojuegoService
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@RestController
@RequestMapping("/videojuegos")
class VideojuegoController(private val videojuegoService: VideojuegoService) {
    /*
    @GetMapping
    fun obtenerTodosLosVideojuegos(): ResponseEntity<List<Videojuego>> {
        val videojuegos = videojuegoService.obtenerTodosLosVideojuegos()
        return ResponseEntity.ok(videojuegos)
    }

    @GetMapping("/{id}")
    fun obtenerVideojuegoPorId(@PathVariable id: String): ResponseEntity<Videojuego> {
        val videojuego = videojuegoService.obtenerVideojuegoPorId(id)
                .orElseThrow { RuntimeException("Videojuego no encontrado con ID: $id") }

        return ResponseEntity.ok(videojuego)
    }
    */

    @GetMapping("/agregarVideojuego")
    fun mostrarAgregarVideojuego(model: Model): String {
        model.addAttribute("videojuego", Videojuego())  // Inicializa un nuevo objeto Videojuego en el modelo
        return "agregarVideojuego"
    }

    @PostMapping("/guardarVideojuego")
    fun agregarVideojuego(@ModelAttribute("videojuego") videojuego: Videojuego, redirectAttributes: RedirectAttributes): String {
        // Lógica para guardar el videojuego en la base de datos
        videojuegoService.guardarVideojuego(videojuego)

        // Redirige a donde desees después de guardar
        return "redirect:/"
    }

    /*
    @PutMapping("/{id}")
    fun actualizarVideojuego(@PathVariable id: String, @RequestBody videojuego: Videojuego): ResponseEntity<Videojuego> {
        val videojuegoActualizado = videojuegoService.actualizarVideojuego(id, videojuego)
        return ResponseEntity.ok(videojuegoActualizado)
    }

    @DeleteMapping("/{id}")
    fun eliminarVideojuego(@PathVariable id: String): ResponseEntity<Void> {
        videojuegoService.eliminarVideojuego(id)
        return ResponseEntity.noContent().build()
    }
    */
}
