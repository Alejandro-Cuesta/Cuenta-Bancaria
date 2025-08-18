package dev.alejandro.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CuentaAhorrosTest {

    @Test
    void operacionesRestringidasCuandoInactiva() {
        // Inactiva porque saldo inicial < 10000
        CuentaAhorros ahorro = new CuentaAhorros(9000f, 0.03f);
        assertFalse(ahorro.isActiva());

        ahorro.consignar(2000f); // NO hace nada porque está inactiva según el enunciado
        ahorro.retirar(500f);    // NO hace nada por misma razón

        assertEquals(9000f, ahorro.getSaldo(), 0.01);

        // extracto aplica interés mensual: 9000 + 9000*(0.03/12) = 9022.5
        ahorro.extractoMensual();
        assertEquals(9022.5f, ahorro.getSaldo(), 0.01);
        assertFalse(ahorro.isActiva()); // sigue inactiva (<10000)
    }

    @Test
    void comisionPorRetirosMayorA4_yCambioDeEstado() {
        // Activa al inicio
        CuentaAhorros ahorro = new CuentaAhorros(15000f, 0.03f);

        // 5 retiros de 1000 -> saldo 10000; numeroRetiros=5
        for (int i = 0; i < 5; i++) ahorro.retirar(1000f);

        // extracto: comisión 1000 (1 retiro extra), saldo 10000-1000=9000
        // + interés mensual: 9000*(0.03/12) = 22.5 -> 9022.5
        ahorro.extractoMensual();

        assertEquals(9022.5f, ahorro.getSaldo(), 0.01);
        assertFalse(ahorro.isActiva()); // < 10000 => inactiva
        assertEquals(0f, ahorro.getComisionMensual(), 0.0); // se resetea tras el extracto
    }
}
