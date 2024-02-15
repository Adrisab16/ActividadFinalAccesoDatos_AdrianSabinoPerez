package com.example.actividadfinalaccesodatos_adriansabinoperez.Service

import com.example.actividadfinalaccesodatos_adriansabinoperez.Entity.EmpresaDesarrolladora
import com.example.actividadfinalaccesodatos_adriansabinoperez.Repository.EmpresaDesarrolladoraRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class EmpresaDesarrolladoraService(private val empresaDesarrolladoraRepository: EmpresaDesarrolladoraRepository) {

    fun obtenerTodasLasEmpresas(): List<EmpresaDesarrolladora> {
        return empresaDesarrolladoraRepository.findAll()
    }

    fun obtenerEmpresaPorId(id: String): Optional<EmpresaDesarrolladora> {
        return empresaDesarrolladoraRepository.findById(id)
    }

    fun guardarEmpresa(empresa: EmpresaDesarrolladora): EmpresaDesarrolladora {
        return empresaDesarrolladoraRepository.save(empresa)
    }

    fun actualizarEmpresa(id: String, nuevaEmpresa: EmpresaDesarrolladora): EmpresaDesarrolladora {
        val empresaExistente = empresaDesarrolladoraRepository.findById(id)
                .orElseThrow { RuntimeException("Empresa no encontrada con ID: $id") }

        // Actualizar propiedades de la empresa existente con las de la nueva empresa
        empresaExistente.nombre = nuevaEmpresa.nombre
        empresaExistente.fechaCreacion = nuevaEmpresa.fechaCreacion
        empresaExistente.videojuegosCreados = nuevaEmpresa.videojuegosCreados
        empresaExistente.enActivo = nuevaEmpresa.enActivo

        return empresaDesarrolladoraRepository.save(empresaExistente)
    }

    fun eliminarEmpresa(id: String) {
        empresaDesarrolladoraRepository.deleteById(id)
    }
}
