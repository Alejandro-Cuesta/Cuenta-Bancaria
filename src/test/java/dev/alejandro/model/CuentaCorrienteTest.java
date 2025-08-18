package dev.alejandro.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaCorrienteTest {

    @Test
    void testRetiroConSobregiro() {
        CuentaCorriente corriente = new CuentaCorriente(1000, 0.05f);
        corriente.retirar(1500);
        assertEquals(-500, corriente.getSaldo(), 0.001);
        assertEquals(500, corriente.getSobregiro(), 0.001);
    }

    @Test
    void testConsignarReduceSobregiro() {
        CuentaCorriente corriente = new CuentaCorriente(1000, 0.05f);
        corriente.retirar(1500);
        corriente.consignar(300);
        assertEquals(200, corriente.getSobregiro(), 0.001);
        assertEquals(0, corriente.getSaldo(), 0.001);
    }

    @Test
    void testExtractoMensual() {
        CuentaCorriente corriente = new CuentaCorriente(2000, 0.05f);
        corriente.retirar(2500);
        corriente.extractoMensual(); // 👈 usamos el nombre correcto
        assertTrue(corriente.getSobregiro() >= 500);
    }
}


