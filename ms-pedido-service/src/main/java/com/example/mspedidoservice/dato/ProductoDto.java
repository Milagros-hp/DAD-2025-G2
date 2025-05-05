package com.example.mspedidoservice.dato;


import lombok.Data;

@Data
public class ProductoDto {
    private Integer id;
    private String nombre;
    private CategoriaDto categoriaDto;
    private Integer stock;
    private String stado;

    public ProductoDto() {
    }

    public ProductoDto(Integer id, String nombre, CategoriaDto categoriaDto,Integer stock,String stado) {
        this.id = id;
        this.nombre = nombre;
        this.categoriaDto = categoriaDto;
        this.stock = stock;
        this.stado = stado;
    }

    public String getStado() {
        return stado;
    }

    public void setStado(String stado) {
        this.stado = stado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CategoriaDto getCategoriaDto() {
        return categoriaDto;
    }

    public void setCategoriaDto(CategoriaDto categoriaDto) {
        this.categoriaDto = categoriaDto;
    }
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
