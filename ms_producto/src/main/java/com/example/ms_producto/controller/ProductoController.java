package com.example.ms_producto.controller;

import com.example.ms_producto.entity.Producto;
import com.example.ms_producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

@Autowired
    private ProductoService productoService;



    @RequestMapping
    public List<Producto> listar() {
        return productoService.listar();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable Integer id) {
        return productoService.buscar(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public Producto guardar (@RequestBody Producto categoria) {
        return productoService.guardar(categoria);
    }

    @PutMapping("/{id}")
    public Producto actualizar ( @PathVariable Integer id,@RequestBody Producto producto) {
        return productoService.actualizar(id, producto);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        productoService.eliminar(id);
    }

    @GetMapping("/productos/filtrar")
    public List<Producto> filtrarProductos(@RequestParam(required = false) String nombre,
                                           @RequestParam(required = false) String categoria,
                                           @RequestParam(required = false) Double precioMin,
                                           @RequestParam(required = false) Double precioMax) {
        return productoService.obtenerProductosFiltrados(nombre, categoria, precioMin, precioMax);
    }


}
