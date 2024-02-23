package com.example.actividadfinalaccesodatos_adriansabinoperez.Entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document("clientes")
data class Cliente(
        @Id
        val dni: String? = null,
        @Field("nombre")
        var nombre: String? = null,
        @Field("apellidos")
        var apellidos: String? = null,
        @Field("edad")
        var edad: String? = null,
        @Field("direccion")
        var direccion: String? = null
)
