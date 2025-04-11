package com.example.ms_producto.service;


import com.example.ms_producto.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> buscar(Integer id);
    Producto guardar (Producto producto);
    Producto actualizar (Integer id,Producto producto);
    void eliminar (Integer id);
    List<Producto> obtenerProductosFiltrados(String nombre, String categoria, Double precioMin, Double precioMax);

}
