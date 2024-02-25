package com.example.actividadfinalaccesodatos_adriansabinoperez.Controller

import com.example.actividadfinalaccesodatos_adriansabinoperez.Entity.Cliente
import com.example.actividadfinalaccesodatos_adriansabinoperez.Service.ClienteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes

/**
 * Controlador para la gestión de operaciones relacionadas con los clientes.
 *
 * @param clienteService Servicio que proporciona la lógica de negocio para los clientes.
 */
@RestController
@RequestMapping("/clientes")
class ClienteController(@Autowired private val clienteService: ClienteService) {

    /**
     * Obtiene un cliente por su DNI.
     *
     * @param dni DNI del cliente a obtener.
     * @return ResponseEntity con el cliente o un mensaje de error si no se encuentra.
     */
    @GetMapping("/obtenerCliente/")
    fun obtenerClientePorDNI(@RequestParam dni: String): ResponseEntity<Cliente> {
        val cliente = clienteService.obtenerClientePorDNI(dni)
                .orElseThrow { RuntimeException("Cliente no encontrado con DNI: $dni") }

        return ResponseEntity.ok(cliente)
    }

    /**
     * Agrega un nuevo cliente a la base de datos.
     *
     * @param cliente Cliente a guardar.
     * @param redirectAttributes Atributos para la redirección.
     */
    @PostMapping("/guardarCliente")
    fun agregarVideojuego(@ModelAttribute("cliente") cliente: Cliente, redirectAttributes: RedirectAttributes) {
        // Lógica para guardar el videojuego en la base de datos
        clienteService.guardarCliente(cliente)

        print("Guardado")
    }

    /**
     * Actualiza un cliente existente en la base de datos.
     *
     * @param dni DNI del cliente a actualizar.
     * @param cliente Cliente con los nuevos datos.
     * @return ResponseEntity con el cliente actualizado.
     */
    @PutMapping(path = ["/actualizarCliente"], consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
    fun actualizarVideojuego(@RequestParam dni: String, cliente: Cliente): ResponseEntity<Cliente> {
        val clienteActualizado = clienteService.actualizarCliente(dni, cliente)
        return ResponseEntity.ok(clienteActualizado)
    }

    /**
     * Elimina un cliente por su DNI.
     *
     * @param dni DNI del cliente a eliminar.
     * @return ResponseEntity indicando éxito en la operación.
     */
    @DeleteMapping("/eliminarCliente/")
    @Transactional
    fun eliminarCliente(@RequestParam  dni: String): ResponseEntity<Void> {
        println(dni)
        clienteService.eliminarCliente(dni)
        return ResponseEntity.noContent().build()
    }
}
