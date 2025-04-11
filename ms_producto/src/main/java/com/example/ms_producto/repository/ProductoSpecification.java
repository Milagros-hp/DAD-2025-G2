package com.example.ms_producto.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import com.example.ms_producto.entity.Producto;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class ProductoSpecification {

    public static Specification<Producto> filtrarPorNombreCategoriaYPrecio(String nombre, String categoria, Double precioMin, Double precioMax) {
        return (Root<Producto> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction(); // Inicia la condición de filtrado (AND)

            // Filtro por nombre
            if (StringUtils.hasText(nombre)) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("nombre"), "%" + nombre + "%"));
            }

            // Filtro por categoría
            if (StringUtils.hasText(categoria)) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("categoria"), "%" + categoria + "%"));
            }

            // Filtro por precio mínimo
            if (precioMin != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("precio"), precioMin));
            }

            // Filtro por precio máximo
            if (precioMax != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("precio"), precioMax));
            }

            return predicate;
        };
    }
}
