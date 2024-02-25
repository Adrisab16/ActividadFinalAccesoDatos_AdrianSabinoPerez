package com.example.actividadfinalaccesodatos_adriansabinoperez.Entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

/**
 * Entidad que representa un videojuego en la base de datos MongoDB.
 *
 * @property id Identificador único del videojuego.
 * @property nombre Nombre del videojuego.
 * @property genero Género del videojuego.
 * @property puntuacion Puntuación del videojuego.
 * @property idEmpresa Identificador único de la empresa desarrolladora del videojuego.
 */
@Document("videojuegos")
data class Videojuego(
        @Id
        var id: String? = null,

        @Field("nombre")
        var nombre: String? = null,

        @Field("genero")
        var genero: String? = null,

        @Field("puntuacion")
        var puntuacion: Int? = null,

        @Field("id_empresa")
        var idEmpresa: String? = null
)

