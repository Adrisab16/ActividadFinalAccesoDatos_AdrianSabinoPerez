package com.example.actividadfinalaccesodatos_adriansabinoperez.Repository

import com.example.actividadfinalaccesodatos_adriansabinoperez.Entity.Videojuego
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface VideojuegoRepository : MongoRepository<Videojuego, String>
