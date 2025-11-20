package com.ritualcoffee.crm.repository;

import com.ritualcoffee.crm.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    // Para futuras consultas filtradas
    List<Producto> findByCategoria(String categoria);
    List<Producto> findByCategoriaAndTipo(String categoria, String tipo);
}
