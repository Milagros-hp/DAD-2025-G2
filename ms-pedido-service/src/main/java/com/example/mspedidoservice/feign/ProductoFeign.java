package com.example.mspedidoservice.feign;


import com.example.mspedidoservice.dato.ProductoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-producto-service",path = "/productos")
public interface ProductoFeign {
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> listById(@PathVariable(required = true ) Integer id);
}
