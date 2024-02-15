package com.example.actividadfinalaccesodatos_adriansabinoperez.Controller

import com.example.actividadfinalaccesodatos_adriansabinoperez.Entity.Cliente
import com.example.actividadfinalaccesodatos_adriansabinoperez.Service.ClienteService
import org.springframework.web.bind.annotation.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/clientes")
class ClienteController(private val clienteService: ClienteService) {
    @GetMapping
    fun obtenerTodosLosClientes(): ResponseEntity<List<Cliente>> {
        val clientes = clienteService.obtenerTodosLosClientes()
        return ResponseEntity.ok(clientes)
    }

    @GetMapping("/{dni}")
    fun obtenerClientePorDNI(@PathVariable dni: String): ResponseEntity<Cliente> {
        val cliente = clienteService.obtenerClientePorDNI(dni)
                .orElseThrow { RuntimeException("Cliente no encontrado con DNI: $dni") }

        return ResponseEntity.ok(cliente)
    }

    @PostMapping
    fun agregarCliente(@RequestBody cliente: Cliente): ResponseEntity<Cliente> {
        val clienteGuardado = clienteService.guardarCliente(cliente)
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteGuardado)
    }

    @PutMapping("/{dni}")
    fun actualizarCliente(@PathVariable dni: String, @RequestBody cliente: Cliente): ResponseEntity<Cliente> {
        val clienteActualizado = clienteService.actualizarCliente(dni, cliente)
        return ResponseEntity.ok(clienteActualizado)
    }

    @DeleteMapping("/{dni}")
    fun eliminarCliente(@PathVariable dni: String): ResponseEntity<Void> {
        clienteService.eliminarCliente(dni)
        return ResponseEntity.noContent().build()
    }
}
