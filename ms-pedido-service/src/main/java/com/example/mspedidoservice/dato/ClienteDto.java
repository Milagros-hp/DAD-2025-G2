package com.example.mspedidoservice.dato;


import lombok.Data;

@Data
public class ClienteDto {
    private Integer id;
    private String nombre;
    private String adni;
    private String direccion;
    private String telefono;
    private String stado;


    public ClienteDto() {
    }


    public ClienteDto(Integer id, String nombre, String adni, String direccion, String telefono,String stado) {
        this.id = id;
        this.nombre = nombre;
        this.adni = adni;
        this.direccion = direccion;
        this.telefono = telefono;
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

    public String getAdni() {
        return adni;
    }

    public void setAdni(String adni) {
        this.adni = adni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getStado() {
        return stado;
    }

    public void setStado(String stado) {
        this.stado = stado;
    }
}
