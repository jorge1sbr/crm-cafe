package com.ritualcoffee.crm.service;

import com.ritualcoffee.crm.entity.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> listarTodos();

    List<Producto> listarPorCategoria(String categoria);

    Producto buscarPorId(Integer id);
}
