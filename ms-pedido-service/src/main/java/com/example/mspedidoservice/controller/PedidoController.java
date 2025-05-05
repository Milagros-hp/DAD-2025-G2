package com.example.mspedidoservice.controller;


import com.example.mspedidoservice.entity.Pedido;
import com.example.mspedidoservice.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {


    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos() {
        List<Pedido> pedidos = pedidoService.listar();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPedidoPorId(@PathVariable Integer id) {
        Optional<Pedido> pedido = pedidoService.buscar(id);
        return pedido.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
        try {
            Pedido nuevoPedido = pedidoService.guardar(pedido);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPedido);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().header("error-message", e.getMessage()).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> actualizarPedido(
            @PathVariable Integer id,
            @RequestBody Pedido pedido) {
        Pedido pedidoActualizado = pedidoService.actualizar(id, pedido);
        return ResponseEntity.ok(pedidoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Integer id) {
        pedidoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
