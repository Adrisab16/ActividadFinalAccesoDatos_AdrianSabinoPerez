package com.example.actividadfinalaccesodatos_adriansabinoperez.Entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.Date

@Document
data class EmpresaDesarrolladora(
        @Id
        val id: String? = null,
        var nombre: String,
        var fechaCreacion: Date,
        var videojuegosCreados: Int,
        var enActivo: Boolean
)
