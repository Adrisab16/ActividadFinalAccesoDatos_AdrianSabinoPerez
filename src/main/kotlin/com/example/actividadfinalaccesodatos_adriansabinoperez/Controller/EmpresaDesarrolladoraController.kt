package com.example.actividadfinalaccesodatos_adriansabinoperez.Controller

import com.example.actividadfinalaccesodatos_adriansabinoperez.Entity.EmpresaDesarrolladora
import com.example.actividadfinalaccesodatos_adriansabinoperez.Service.EmpresaDesarrolladoraService
import org.springframework.web.bind.annotation.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/empresasdesarrolladoras")
class EmpresaDesarrolladoraController(private val empresaDesarrolladoraService: EmpresaDesarrolladoraService) {
    @GetMapping
    fun obtenerTodasLasEmpresas(): ResponseEntity<List<EmpresaDesarrolladora>> {
        val empresas = empresaDesarrolladoraService.obtenerTodasLasEmpresas()
        return ResponseEntity.ok(empresas)
    }

    @GetMapping("/{id}")
    fun obtenerEmpresaPorId(@PathVariable id: String): ResponseEntity<EmpresaDesarrolladora> {
        val empresa = empresaDesarrolladoraService.obtenerEmpresaPorId(id)
                .orElseThrow { RuntimeException("Empresa no encontrada con ID: $id") }

        return ResponseEntity.ok(empresa)
    }

    @PostMapping
    fun agregarEmpresa(@RequestBody empresa: EmpresaDesarrolladora): ResponseEntity<EmpresaDesarrolladora> {
        val empresaGuardada = empresaDesarrolladoraService.guardarEmpresa(empresa)
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaGuardada)
    }

    @PutMapping("/{id}")
    fun actualizarEmpresa(@PathVariable id: String, @RequestBody empresa: EmpresaDesarrolladora): ResponseEntity<EmpresaDesarrolladora> {
        val empresaActualizada = empresaDesarrolladoraService.actualizarEmpresa(id, empresa)
        return ResponseEntity.ok(empresaActualizada)
    }

    @DeleteMapping("/{id}")
    fun eliminarEmpresa(@PathVariable id: String): ResponseEntity<Void> {
        empresaDesarrolladoraService.eliminarEmpresa(id)
        return ResponseEntity.noContent().build()
    }
}
