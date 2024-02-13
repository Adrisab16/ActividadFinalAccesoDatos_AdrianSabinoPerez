package com.example.actividadfinalaccesodatos_adriansabinoperez.Entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.Date

@Document
data class EmpresaDesarrolladora(
        @Id
        val id: String? = null,
        val nombre: String,
        val fechaCreacion: Date,
        val videojuegosCreados: Int,
        val enActivo: Boolean
)
