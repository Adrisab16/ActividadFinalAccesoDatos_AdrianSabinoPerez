package com.example.actividadfinalaccesodatos_adriansabinoperez.Controller

import com.example.actividadfinalaccesodatos_adriansabinoperez.Entity.Videojuego
import com.example.actividadfinalaccesodatos_adriansabinoperez.Service.VideojuegoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes

/**
 * Controlador para la gestión de operaciones relacionadas con los videojuegos.
 *
 * @param videojuegoService Servicio que proporciona la lógica de negocio para los videojuegos.
 */
@RestController
@RequestMapping("/videojuegos")
class VideojuegoController(@Autowired private val videojuegoService: VideojuegoService) {

    /**
     * Obtiene un videojuego por su ID.
     *
     * @param id ID del videojuego a obtener.
     * @return ResponseEntity con el videojuego o un mensaje de error si no se encuentra.
     */
    @GetMapping("/obtenerVideojuego/")
    fun obtenerVideojuegoPorId(@RequestParam id: String): ResponseEntity<Videojuego> {
        val videojuego = videojuegoService.obtenerVideojuegoPorId(id)
                .orElseThrow { RuntimeException("Videojuego no encontrado con ID: $id") }

        return ResponseEntity.ok(videojuego)
    }

    /**
     * Agrega un nuevo videojuego a la base de datos.
     *
     * @param videojuego Videojuego a guardar.
     * @param redirectAttributes Atributos para la redirección.
     */
    @PostMapping("/guardarVideojuego")
    fun agregarVideojuego(@ModelAttribute("videojuego") videojuego: Videojuego, redirectAttributes: RedirectAttributes) {
        // Lógica para guardar el videojuego en la base de datos
        videojuegoService.guardarVideojuego(videojuego)

        print("Guardado")
    }

    /**
     * Actualiza un videojuego existente en la base de datos.
     *
     * @param id ID del videojuego a actualizar.
     * @param videojuego Videojuego con los nuevos datos.
     * @return ResponseEntity con el videojuego actualizado.
     */
    @PutMapping(path = ["/actualizarVideojuego"], consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
    fun actualizarVideojuego(@RequestParam id: String, videojuego: Videojuego): ResponseEntity<Videojuego> {
        val videojuegoActualizado = videojuegoService.actualizarVideojuego(id, videojuego)
        return ResponseEntity.ok(videojuegoActualizado)
    }

    /**
     * Elimina un videojuego por su ID.
     *
     * @param id ID del videojuego a eliminar.
     * @return ResponseEntity indicando éxito en la operación.
     */
    @DeleteMapping("/eliminarvideojuego/")
    @Transactional
    fun eliminarVideojuego(@RequestParam id: String): ResponseEntity<Void> {
        println(id)
        videojuegoService.eliminarVideojuego(id)
        return ResponseEntity.noContent().build()
    }
}
