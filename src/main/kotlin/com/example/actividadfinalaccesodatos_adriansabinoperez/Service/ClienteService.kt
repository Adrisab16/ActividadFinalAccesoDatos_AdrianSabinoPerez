package com.example.actividadfinalaccesodatos_adriansabinoperez.Service

import com.example.actividadfinalaccesodatos_adriansabinoperez.Entity.Cliente
import com.example.actividadfinalaccesodatos_adriansabinoperez.Repository.ClienteRepository
import org.springframework.stereotype.Service
import java.util.*

/**
 * Servicio que gestiona la lógica de negocio relacionada con la entidad Cliente en la base de datos.
 *
 * @property clienteRepository Repositorio para acceder a la base de datos de clientes.
 */
@Service
class ClienteService(private val clienteRepository: ClienteRepository) {

    /**
     * Obtiene un cliente por su DNI.
     *
     * @param dni DNI del cliente a buscar.
     * @return Cliente encontrado, o un Optional vacío si no existe.
     */
    fun obtenerClientePorDNI(dni: String): Optional<Cliente> {
        return clienteRepository.findById(dni)
    }

    /**
     * Guarda un nuevo cliente en la base de datos.
     *
     * @param cliente Cliente a ser guardado.
     * @return Cliente guardado.
     */
    fun guardarCliente(cliente: Cliente): Cliente {
        return clienteRepository.save(cliente)
    }

    /**
     * Actualiza un cliente existente en la base de datos.
     *
     * @param dni DNI del cliente a actualizar.
     * @param nuevoCliente Cliente con los nuevos datos.
     * @return Cliente actualizado.
     * @throws RuntimeException Si no se encuentra el cliente con el DNI especificado.
     */
    fun actualizarCliente(dni: String, nuevoCliente: Cliente): Cliente {
        val clienteExistente = clienteRepository.findById(dni)
                .orElseThrow { RuntimeException("Cliente no encontrado con DNI: $dni") }

        // Actualizar propiedades del cliente existente con las del nuevo cliente
        clienteExistente.nombre = nuevoCliente.nombre
        clienteExistente.apellidos = nuevoCliente.apellidos
        clienteExistente.edad = nuevoCliente.edad
        clienteExistente.direccion = nuevoCliente.direccion

        return clienteRepository.save(clienteExistente)
    }

    /**
     * Elimina un cliente de la base de datos por su DNI.
     *
     * @param dni DNI del cliente a ser eliminado.
     */
    fun eliminarCliente(dni: String) {
        clienteRepository.deleteById(dni)
    }
}
