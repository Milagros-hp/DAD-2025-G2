package com.example.mspedidoservice.entity;

import com.example.mspedidoservice.dato.ClienteDto;
import com.example.mspedidoservice.dato.ProductoDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String serie;
    private String numero;
    private String descripcion;
    private Integer clienteId;

    @Transient
    private ClienteDto clienteDto;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "venta_id")
    private List<PedidoDetalle> detalles;


    public Pedido() {
    }

    public Pedido(Integer id, String serie, String numero, String descripcion, Integer clienteId, List<PedidoDetalle> detalles, ClienteDto clienteDto) {
        this.id = id;
        this.serie = serie;
        this.numero = numero;
        this.descripcion = descripcion;
        this.clienteId = clienteId;
        this.detalles = detalles;
        this.clienteDto= clienteDto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public List<PedidoDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<PedidoDetalle> detalles) {
        this.detalles = detalles;
    }
    public ClienteDto getClienteDto() {
        return clienteDto;
    }

    public void setClienteDato(ClienteDto clienteDto ) {
        this.clienteDto = clienteDto;
    }
}
