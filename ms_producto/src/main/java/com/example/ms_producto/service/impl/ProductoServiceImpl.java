package com.example.ms_producto.service.impl;

import com.example.ms_producto.entity.Producto;
import com.example.ms_producto.repository.ProductoRepository;
import com.example.ms_producto.repository.ProductoSpecification;
import com.example.ms_producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;  // Esto es correcto


@Service
public class ProductoServiceImpl implements ProductoService {


    @Autowired
    private ProductoRepository productoRepository;


    @Override
    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> buscar(Integer id) {

        return productoRepository.findById(id);
    }

    @Override
    public Producto guardar(Producto categoria) {
        return productoRepository.save(categoria);
    }

    @Override
    public Producto actualizar (Integer id , Producto categoria) {
        categoria.setId(id);
        return productoRepository.save(categoria);
    }

    @Override
    public void eliminar(Integer id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> obtenerProductosFiltrados(String nombre, String categoria, Double precioMin, Double precioMax) {
        // Llamada al repositorio con las especificaciones
        Pageable pageable = PageRequest.of(0, 10);  // Puedes ajustar los parámetros de paginación
        return productoRepository.findAll(ProductoSpecification.filtrarPorNombreCategoriaYPrecio(nombre, categoria, precioMin, precioMax), pageable).getContent();
    }




}
