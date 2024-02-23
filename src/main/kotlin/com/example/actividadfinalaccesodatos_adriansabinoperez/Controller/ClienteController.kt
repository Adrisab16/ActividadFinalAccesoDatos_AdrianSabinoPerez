package com.example.actividadfinalaccesodatos_adriansabinoperez.Controller

import com.example.actividadfinalaccesodatos_adriansabinoperez.Entity.Cliente
import com.example.actividadfinalaccesodatos_adriansabinoperez.Service.ClienteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@RestController
@RequestMapping("/clientes")
class ClienteController(@Autowired private val clienteService: ClienteService) {

    @GetMapping("/obtenerCliente/")
    fun obtenerClientePorDNI(@RequestParam dni: String): ResponseEntity<Cliente> {
        val cliente = clienteService.obtenerClientePorDNI(dni)
                .orElseThrow { RuntimeException("Cliente no encontrado con DNI: $dni") }

        return ResponseEntity.ok(cliente)
    }

    @PostMapping("/guardarCliente")
    fun agregarVideojuego(@ModelAttribute("cliente") cliente: Cliente, redirectAttributes: RedirectAttributes) {
        // Lógica para guardar el videojuego en la base de datos
        clienteService.guardarCliente(cliente)

        print("Guardado")
    }

    @PutMapping(path = ["/actualizarCliente"], consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
    fun actualizarVideojuego(@RequestParam dni: String, cliente: Cliente): ResponseEntity<Cliente> {
        val clienteActualizado = clienteService.actualizarCliente(dni, cliente)
        return ResponseEntity.ok(clienteActualizado)
    }

    @DeleteMapping("/eliminarCliente/")
    @Transactional
    fun eliminarCliente(@RequestParam  dni: String): ResponseEntity<Void> {
        println(dni)
        clienteService.eliminarCliente(dni)
        return ResponseEntity.noContent().build()
    }
}
