package com.example.mspedidoservice.util;

import com.example.mspedidoservice.entity.Pedido;
import com.example.mspedidoservice.entity.PedidoDetalle;
import com.example.mspedidoservice.repository.PedidoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class PedidoSeeder implements CommandLineRunner {
    private final PedidoRepository pedidoRepository;

    public PedidoSeeder(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;

    }

    @Override
    public void run(String... args) {
        if (pedidoRepository.count() == 0) {
            // Pedido 1
            Pedido pedido1 = new Pedido();
            pedido1.setSerie("P001");
            pedido1.setNumero("0001");
            pedido1.setDescripcion("Pedido de productos electrónicos");
            pedido1.setClienteId(1);

            PedidoDetalle detalle1 = new PedidoDetalle();
            detalle1.setProductoId(101);
            detalle1.setCantidad(2.0);
            detalle1.setPrecio(1200.0);

            PedidoDetalle detalle2 = new PedidoDetalle();
            detalle2.setProductoId(102);
            detalle2.setCantidad(1.0);
            detalle2.setPrecio(850.0);

            pedido1.setDetalles(Arrays.asList(detalle1, detalle2));

            // Pedido 2
            Pedido pedido2 = new Pedido();
            pedido2.setSerie("P001");
            pedido2.setNumero("0002");
            pedido2.setDescripcion("Pedido de ropa");
            pedido2.setClienteId(2);

            PedidoDetalle detalle3 = new PedidoDetalle();
            detalle3.setProductoId(201);
            detalle3.setCantidad(3.0);
            detalle3.setPrecio(150.0);

            pedido2.setDetalles(Arrays.asList(detalle3));

            // Guardar pedidos
            pedidoRepository.save(pedido1);
            pedidoRepository.save(pedido2);

            System.out.println("Datos de pedidos insertados correctamente.");
        } else {
            System.out.println("Ya existen pedidos en la base de datos, no se insertaron datos.");
        }
    }
}
