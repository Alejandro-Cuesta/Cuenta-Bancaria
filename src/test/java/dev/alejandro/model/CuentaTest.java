package dev.alejandro.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuentaTest {

    @Test
    void consignarYRetirar() {
        CuentaAhorros ahorro = new CuentaAhorros(12000f, 0.03f);

        ahorro.consignar(2000f);
        assertEquals(14000f, ahorro.getSaldo(), 0.1);

        ahorro.retirar(4000f);
        assertEquals(10000f, ahorro.getSaldo(), 0.1);
    }

    @Test
    void calcularInteresMensual() {
        CuentaCorriente corriente = new CuentaCorriente(10000f, 0.12f); // 12% anual
        corriente.calcularInteres();
        assertEquals(10100f, corriente.getSaldo(), 0.1);
    }
}