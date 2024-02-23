package com.example.actividadfinalaccesodatos_adriansabinoperez.Service

import com.example.actividadfinalaccesodatos_adriansabinoperez.Entity.Videojuego
import com.example.actividadfinalaccesodatos_adriansabinoperez.Repository.VideojuegoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class VideojuegoService(private val videojuegoRepository: VideojuegoRepository) {
    fun obtenerVideojuegoPorId(id: String): Optional<Videojuego> {
        return videojuegoRepository.findById(id)
    }

    fun guardarVideojuego(videojuego: Videojuego): Videojuego {
        return videojuegoRepository.save(videojuego)
    }

    fun actualizarVideojuego(id: String, nuevoVideojuego: Videojuego): Videojuego {
        val videojuegoExistente = videojuegoRepository.findById(id)
                .orElseThrow { RuntimeException("Videojuego no encontrado con ID: $id") }

        // Actualizar propiedades del videojuego existente con las del nuevo videojuego
        videojuegoExistente.nombre = nuevoVideojuego.nombre
        videojuegoExistente.empresaDesarrolladora = nuevoVideojuego.empresaDesarrolladora
        videojuegoExistente.genero = nuevoVideojuego.genero
        videojuegoExistente.puntuacion = nuevoVideojuego.puntuacion
        videojuegoExistente.idEmpresa = nuevoVideojuego.idEmpresa

        return videojuegoRepository.save(videojuegoExistente)
    }

    fun eliminarVideojuego(id: String) {
        videojuegoRepository.deleteById(id)
    }
}
