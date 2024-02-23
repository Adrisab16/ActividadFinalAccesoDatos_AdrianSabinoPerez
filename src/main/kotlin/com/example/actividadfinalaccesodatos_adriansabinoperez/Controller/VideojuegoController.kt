package com.example.actividadfinalaccesodatos_adriansabinoperez.Controller

import com.example.actividadfinalaccesodatos_adriansabinoperez.Entity.Videojuego
import com.example.actividadfinalaccesodatos_adriansabinoperez.Service.VideojuegoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@RestController
@RequestMapping("/videojuegos")
class VideojuegoController(@Autowired private val videojuegoService: VideojuegoService) {

    @GetMapping("/obtenerVideojuego/")
    fun obtenerVideojuegoPorId(@RequestParam id: String): ResponseEntity<Videojuego> {
        val videojuego = videojuegoService.obtenerVideojuegoPorId(id)
                .orElseThrow { RuntimeException("Videojuego no encontrado con ID: $id") }

        return ResponseEntity.ok(videojuego)
    }

    @PostMapping("/guardarVideojuego")
    fun agregarVideojuego(@ModelAttribute("videojuego") videojuego: Videojuego, redirectAttributes: RedirectAttributes) {
        // Lógica para guardar el videojuego en la base de datos
        videojuegoService.guardarVideojuego(videojuego)

        print("Guardado")
    }

    @PutMapping(path = ["/actualizarVideojuego"], consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
    fun actualizarVideojuego(@RequestParam id: String, videojuego: Videojuego): ResponseEntity<Videojuego> {
        val videojuegoActualizado = videojuegoService.actualizarVideojuego(id, videojuego)
        return ResponseEntity.ok(videojuegoActualizado)
    }


    @DeleteMapping("/eliminarvideojuego/")
    @Transactional
    fun eliminarVideojuego(@RequestParam id: String): ResponseEntity<Void> {
        println(id)
        videojuegoService.eliminarVideojuego(id)
        return ResponseEntity.noContent().build()
    }
}
