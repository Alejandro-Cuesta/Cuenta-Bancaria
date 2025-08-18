package dev.alejandro.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CuentaCorrienteTest {

    @Test
    void retiroConSobregiro() {
        CuentaCorriente corriente = new CuentaCorriente(1000f, 0.05f);
        corriente.retirar(1500f);
        // En nuestro modelo: saldo nunca es negativo; el exceso va a sobregiro
        assertEquals(0f, corriente.getSaldo(), 0.01);
        assertEquals(500f, corriente.getSobregiro(), 0.01);
        assertEquals(1, corriente.getNumeroRetiros());
    }

    @Test
    void consignarReduceSobregiroPrimero() {
        CuentaCorriente corriente = new CuentaCorriente(1000f, 0.05f);
        corriente.retirar(1500f);     // sobregiro = 500
        corriente.consignar(300f);    // cubre parte del sobregiro
        assertEquals(200f, corriente.getSobregiro(), 0.01);
        assertEquals(0f, corriente.getSaldo(), 0.01);
        assertEquals(1, corriente.getNumeroConsignaciones()); // consignación cuenta aunque quede en 0
    }

    @Test
    void extractoMensualMantieneSobregiro() {
        CuentaCorriente corriente = new CuentaCorriente(2000f, 0.12f);
        corriente.retirar(2500f);     // saldo=0, sobregiro=500
        corriente.extractoMensual();  // interés sobre saldo (0) => 0; sobregiro queda igual
        assertEquals(0f, corriente.getSaldo(), 0.01);
        assertEquals(500f, corriente.getSobregiro(), 0.01);
    }

    @Test
    void extractoMensualConSaldoPositivoAplicaInteres() {
        CuentaCorriente corriente = new CuentaCorriente(1000f, 0.12f);
        corriente.consignar(1000f);   // saldo=2000
        corriente.extractoMensual();  // + 1% mensual => 2020
        assertEquals(2020f, corriente.getSaldo(), 0.01);
    }
}