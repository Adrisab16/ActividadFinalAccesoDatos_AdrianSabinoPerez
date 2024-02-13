package com.example.actividadfinalaccesodatos_adriansabinoperez.Entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.Date

@Document
data class Videojuego(
        @Id
        val id: String? = null,
        val nombre: String,
        val empresaDesarrolladora: String,
        val genero: String,
        val fechaPublicacion: Date,
        val puntuacion: Double,
        val idEmpresa: String // Puede ser el ID de la Empresa_Desarrolladora
)
