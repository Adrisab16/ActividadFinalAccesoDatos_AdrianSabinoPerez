package com.example.actividadfinalaccesodatos_adriansabinoperez.Service

import com.example.actividadfinalaccesodatos_adriansabinoperez.Entity.Videojuego
import com.example.actividadfinalaccesodatos_adriansabinoperez.Repository.VideojuegoRepository
import org.springframework.stereotype.Service
import java.util.*

/**
 * Servicio que gestiona operaciones relacionadas con la entidad Videojuego.
 *
 * @property videojuegoRepository Repositorio para acceder a la base de datos de Videojuegos.
 */

@Service
class VideojuegoService(private val videojuegoRepository: VideojuegoRepository) {

    /**
     * Obtiene un videojuego por su identificador único.
     *
     * @param id Identificador único del videojuego.
     * @return Optional que contiene el videojuego si se encuentra, o un Optional vacío si no.
     */
    fun obtenerVideojuegoPorId(id: String): Optional<Videojuego> {
        return videojuegoRepository.findById(id)
    }

    /**
     * Guarda un nuevo videojuego en la base de datos.
     *
     * @param videojuego Videojuego a guardar.
     * @return Videojuego guardado en la base de datos.
     */
    fun guardarVideojuego(videojuego: Videojuego): Videojuego {
        return videojuegoRepository.save(videojuego)
    }

    /**
     * Actualiza un videojuego existente en la base de datos.
     *
     * @param id Identificador único del videojuego a actualizar.
     * @param nuevoVideojuego Datos actualizados del videojuego.
     * @return Videojuego actualizado en la base de datos.
     * @throws RuntimeException Si el videojuego con el ID proporcionado no se encuentra.
     */
    fun actualizarVideojuego(id: String, nuevoVideojuego: Videojuego): Videojuego {
        val videojuegoExistente = videojuegoRepository.findById(id)
                .orElseThrow { RuntimeException("Videojuego no encontrado con ID: $id") }

        // Actualizar propiedades del videojuego existente con las del nuevo videojuego
        videojuegoExistente.nombre = nuevoVideojuego.nombre
        videojuegoExistente.genero = nuevoVideojuego.genero
        videojuegoExistente.puntuacion = nuevoVideojuego.puntuacion
        videojuegoExistente.idEmpresa = nuevoVideojuego.idEmpresa

        return videojuegoRepository.save(videojuegoExistente)
    }

    /**
     * Elimina un videojuego de la base de datos por su identificador único.
     *
     * @param id Identificador único del videojuego a eliminar.
     */
    fun eliminarVideojuego(id: String) {
        videojuegoRepository.deleteById(id)
    }
}
