package com.example.actividadfinalaccesodatos_adriansabinoperez.Controller

import com.example.actividadfinalaccesodatos_adriansabinoperez.Entity.Videojuego
import com.example.actividadfinalaccesodatos_adriansabinoperez.Service.VideojuegoService
import org.springframework.web.bind.annotation.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/videojuegos")
class VideojuegoController(private val videojuegoService: VideojuegoService) {
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

    @PostMapping
    fun agregarVideojuego(@RequestBody videojuego: Videojuego): ResponseEntity<Videojuego> {
        val videojuegoGuardado = videojuegoService.guardarVideojuego(videojuego)
        return ResponseEntity.status(HttpStatus.CREATED).body(videojuegoGuardado)
    }

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
}
