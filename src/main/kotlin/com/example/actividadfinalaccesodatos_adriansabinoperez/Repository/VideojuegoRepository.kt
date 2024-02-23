package com.example.actividadfinalaccesodatos_adriansabinoperez.Repository

import com.example.actividadfinalaccesodatos_adriansabinoperez.Entity.Videojuego
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Videojuego en MongoDB.
 *
 * Esta interfaz extiende MongoRepository, proporcionando operaciones CRUD estándar y métodos adicionales
 * que pueden ser personalizados según las necesidades de la aplicación.
 *
 * @param Videojuego Tipo de la entidad que se gestionará (Videojuego en este caso).
 * @param String Tipo del identificador de la entidad (String en este caso).
 */
@Repository
interface VideojuegoRepository : MongoRepository<Videojuego, String>
