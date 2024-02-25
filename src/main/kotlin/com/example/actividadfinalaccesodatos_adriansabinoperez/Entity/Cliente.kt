package com.example.actividadfinalaccesodatos_adriansabinoperez.Entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

/**
 * Clase que representa la entidad Cliente en la base de datos.
 *
 * @property dni DNI del cliente (identificador único).
 * @property nombre Nombre del cliente.
 * @property apellidos Apellidos del cliente.
 * @property edad Edad del cliente.
 * @property direccion Dirección del cliente.
 */
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
