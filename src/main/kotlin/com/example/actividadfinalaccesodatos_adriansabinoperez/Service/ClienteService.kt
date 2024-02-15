package com.example.actividadfinalaccesodatos_adriansabinoperez.Service

import com.example.actividadfinalaccesodatos_adriansabinoperez.Entity.Cliente
import com.example.actividadfinalaccesodatos_adriansabinoperez.Repository.ClienteRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ClienteService(private val clienteRepository: ClienteRepository) {

    fun obtenerTodosLosClientes(): List<Cliente> {
        return clienteRepository.findAll()
    }

    fun obtenerClientePorDNI(dni: String): Optional<Cliente> {
        return clienteRepository.findById(dni)
    }

    fun guardarCliente(cliente: Cliente): Cliente {
        return clienteRepository.save(cliente)
    }

    fun actualizarCliente(dni: String, nuevoCliente: Cliente): Cliente {
        val clienteExistente = clienteRepository.findById(dni)
                .orElseThrow { RuntimeException("Cliente no encontrado con DNI: $dni") }

        // Actualizar propiedades del cliente existente con las del nuevo cliente
        clienteExistente.nombre = nuevoCliente.nombre
        clienteExistente.apellidos = nuevoCliente.apellidos
        clienteExistente.edad = nuevoCliente.edad
        clienteExistente.codigoPostal = nuevoCliente.codigoPostal
        clienteExistente.direccion = nuevoCliente.direccion

        return clienteRepository.save(clienteExistente)
    }

    fun eliminarCliente(dni: String) {
        clienteRepository.deleteById(dni)
    }
}
