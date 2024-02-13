package com.example.actividadfinalaccesodatos_adriansabinoperez.Entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Cliente(
        @Id
        val dni: String,
        val nombre: String,
        val apellidos: String,
        val edad: Int,
        val codigoPostal: String,
        val direccion: String
)
