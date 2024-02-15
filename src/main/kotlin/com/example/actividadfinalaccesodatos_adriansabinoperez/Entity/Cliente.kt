package com.example.actividadfinalaccesodatos_adriansabinoperez.Entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Cliente(
        @Id
        val dni: String,
        var nombre: String,
        var apellidos: String,
        var edad: Int,
        var codigoPostal: String,
        var direccion: String
)
