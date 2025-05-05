package com.example.mspedidoservice.service.impl;

import com.example.mspedidoservice.dato.ClienteDto;
import com.example.mspedidoservice.dato.ProductoDto;
import com.example.mspedidoservice.entity.Pedido;
import com.example.mspedidoservice.entity.PedidoDetalle;
import com.example.mspedidoservice.feign.ClienteFeign;
import com.example.mspedidoservice.feign.ProductoFeign;
import com.example.mspedidoservice.repository.PedidoRepository;
import com.example.mspedidoservice.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteFeign clienteFeign;

    @Autowired
    private ProductoFeign productoFeign;


    @Override
    public List<Pedido> listar() {

        List<Pedido> pedidos = pedidoRepository.findAll();

        for (Pedido pedido : pedidos) {
            ClienteDto clienteDto = clienteFeign.listById(pedido.getClienteId()).getBody();
            pedido.setClienteDato(clienteDto);

            for (PedidoDetalle pedidoDetalle : pedido.getDetalles()) {
                ProductoDto productoDto = productoFeign.listById(pedidoDetalle.getProductoId()).getBody();
                pedidoDetalle.setProductoDto(productoDto);
            }

        }

        return pedidos;
    }

    @Override
    public Optional<Pedido> buscar(Integer id) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
        optionalPedido.ifPresent(pedido -> {
            ClienteDto clienteDto = clienteFeign.listById(pedido.getClienteId()).getBody();
            pedido.setClienteDato(clienteDto);

            for (PedidoDetalle pedidoDetalle : pedido.getDetalles()) {
                ProductoDto productoDto = productoFeign.listById(pedidoDetalle.getProductoId()).getBody();
                pedidoDetalle.setProductoDto(productoDto);
            }
        });


        return optionalPedido;
    }

    @Override
    public Pedido guardar(Pedido pedido) {
        ClienteDto clienteDto = clienteFeign.listById(pedido.getClienteId()).getBody();

        // 2. Validar que el cliente existe y está activo
        if (clienteDto == null || !"activo".equals(clienteDto.getStado())) {
            throw new RuntimeException("El cliente no existe o no está activo");
        }

        // 3. Procesar detalles del pedido (similar a tu método listar)
        for (PedidoDetalle detalle : pedido.getDetalles()) {
            ProductoDto productoDto = productoFeign.listById(detalle.getProductoId()).getBody();
            detalle.setProductoDto(productoDto);

            // Validación opcional del producto
            if (productoDto == null) {
                throw new RuntimeException("Producto no encontrado: " + detalle.getProductoId());
            }
        }

        // 4. Asignar datos del cliente al pedido (como en listar)
        pedido.setClienteDato(clienteDto);

        // 5. Guardar el pedido
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido actualizar (Integer id, Pedido pedido){
        pedido.setId(id);

        return pedidoRepository.save(pedido);
    }

    @Override
    public void eliminar (Integer id){
        pedidoRepository.deleteById(id);
    }

}