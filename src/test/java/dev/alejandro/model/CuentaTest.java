package dev.alejandro.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CuentaTest {

    @Test
    void consignarYRetirar_UsandoCuentaAhorrosActiva() {
        CuentaAhorros ahorro = new CuentaAhorros(12000f, 0.03f);
        ahorro.consignar(2000f);         // 14000
        assertEquals(14000f, ahorro.getSaldo(), 0.01);

        ahorro.retirar(4000f);           // 10000
        assertEquals(10000f, ahorro.getSaldo(), 0.01);

        assertEquals(1, ahorro.getNumeroConsignaciones());
        assertEquals(1, ahorro.getNumeroRetiros());
    }

    @Test
    void calcularInteresMensual_Base() {
        // 12% anual => 1% mensual
        CuentaCorriente cc = new CuentaCorriente(10000f, 0.12f);
        cc.calcularInteres();
        assertEquals(10100f, cc.getSaldo(), 0.01);
    }
}
