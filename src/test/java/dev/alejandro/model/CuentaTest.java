package dev.alejandro.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void testConsignarAumentaSaldo() {
        Cuenta cuenta = new Cuenta(1000, 12);
        cuenta.consignar(500);

        assertEquals(1500, cuenta.getSaldo(), 0.001);
        assertEquals(1, cuenta.getNumeroConsignaciones());
    }

    @Test
    void testRetirarDisminuyeSaldo() {
        Cuenta cuenta = new Cuenta(1000, 12);
        cuenta.retirar(400);

        assertEquals(600, cuenta.getSaldo(), 0.001);
        assertEquals(1, cuenta.getNumeroRetiros());
    }

    @Test
    void testRetirarMasDelSaldoNoCambiaNada() {
        Cuenta cuenta = new Cuenta(1000, 12);
        cuenta.retirar(2000); // intento inválido

        assertEquals(1000, cuenta.getSaldo(), 0.001);
        assertEquals(0, cuenta.getNumeroRetiros());
    }

    @Test
    void testCalcularInteresMensual() {
        Cuenta cuenta = new Cuenta(1200, 12); // 12% anual
        cuenta.calcularInteresMensual(); // 1% mensual sobre 1200 = 12

        assertEquals(1212, cuenta.getSaldo(), 0.001);
    }

    @Test
    void testExtractoMensualRestaComisionYAplicaInteres() {
        Cuenta cuenta = new Cuenta(1000, 12); // 12% anual = 1% mensual
        cuenta.setComisionMensual(50);
        cuenta.extractoMensual();

        // saldo esperado = (1000 - 50) + (950 * 0.01) = 959.5
        assertEquals(959.5, cuenta.getSaldo(), 0.001);
    }

    @Test
    void testImprimirDevuelveInfo() {
        Cuenta cuenta = new Cuenta(500, 12);
        String info = cuenta.imprimir();

        assertTrue(info.contains("Saldo:"));
        assertTrue(info.contains("Comisión Mensual"));
    }
}