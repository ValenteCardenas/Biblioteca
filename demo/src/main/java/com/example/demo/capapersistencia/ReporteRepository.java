package com.example.demo.capapersistencia;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.capanegocio.modelo.Reporte;

public interface ReporteRepository extends CrudRepository<Reporte, Long> {
    public Reporte findByNombre(String nombre);
    public Reporte findByTipo(String tipo);

}
