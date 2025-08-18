package dev.alejandro.service;

import dev.alejandro.model.CuentaAhorros;
import dev.alejandro.model.CuentaCorriente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CuentaServiceTest {

    @Test
    void testConsignarYRetirarEnCuentaAhorros() {
        CuentaService service = new CuentaService();
        CuentaAhorros ahorro = new CuentaAhorros(12000f, 0.03f);

        service.consignar(ahorro, 1000f);   // saldo = 13000
        service.retirar(ahorro, 3000f);     // saldo = 10000
        service.generarExtracto(ahorro);   // +interés

        assertTrue(ahorro.getSaldo() > 10000f); // interés aplicado
        assertEquals(1, ahorro.getNumeroConsignaciones());
        assertEquals(1, ahorro.getNumeroRetiros());
    }

    @Test
    void testConsignarYRetirarEnCuentaCorriente() {
        CuentaService service = new CuentaService();
        CuentaCorriente corriente = new CuentaCorriente(500f, 0.05f);

        service.retirar(corriente, 800f);  // sobregiro = 300
        service.consignar(corriente, 200f); // sobregiro = 100
        service.generarExtracto(corriente); // interés sobre saldo (0)

        assertEquals(100f, corriente.getSobregiro(), 0.01);
        assertEquals(0f, corriente.getSaldo(), 0.01);
    }
}