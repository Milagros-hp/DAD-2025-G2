package com.example.mspagos.util;

import com.example.mspagos.entity.Pago;
import com.example.mspagos.repository.PagoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PagoSeeder implements CommandLineRunner {

    private final PagoRepository pagoRepository;

    public PagoSeeder(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    @Override
    public void run(String... args) {
        if (pagoRepository.count() == 0) {
            pagoRepository.save(new Pago(null, "Pago con tarjeta"));
            pagoRepository.save(new Pago(null, "Pago en efectivo"));
            pagoRepository.save(new Pago(null, "Pago por transferencia"));
            pagoRepository.save(new Pago(null, "Pago con Yape"));
            pagoRepository.save(new Pago(null, "Pago con Plin"));

            System.out.println("Datos de pagos insertados correctamente.");
        } else {
            System.out.println("Los pagos ya existen, no se insertaron datos.");
        }
    }
}
