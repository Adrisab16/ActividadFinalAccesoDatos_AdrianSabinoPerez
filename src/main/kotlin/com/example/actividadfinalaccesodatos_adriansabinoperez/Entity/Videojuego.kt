package com.example.actividadfinalaccesodatos_adriansabinoperez.Entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field


@Document("videojuegos")
data class Videojuego(
        @Id
        var id: String? = null,

        @Field("nombre")
        var nombre: String? = null,

        @Field("empresa_desarrolladora")
        var empresaDesarrolladora: String? = null,

        @Field("genero")
        var genero: String? = null,

        @Field("fecha_publicacion")
        var fechaPublicacion: String? = null,

        @Field("puntuacion")
        var puntuacion: Int? = null,

        @Field("id_empresa")
        var idEmpresa: Int? = null
)