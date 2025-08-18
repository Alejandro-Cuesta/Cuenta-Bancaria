package dev.alejandro;

import dev.alejandro.controller.CuentaController;
import dev.alejandro.model.CuentaAhorros;
import dev.alejandro.model.CuentaCorriente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void flujoPrincipalCuentas() {
        CuentaController controller = new CuentaController();

        // Ahorros: saldo final = 16541.25
        CuentaAhorros ahorro = new CuentaAhorros(15000f, 0.03f);
        controller.consignar(ahorro, 2000f);     // 17000
        controller.retirar(ahorro, 500f);        // 16500
        controller.generarExtracto(ahorro);      // + 16500*(0.03/12) = +41.25 => 16541.25

        assertTrue(ahorro.isActiva());
        assertEquals(16541.25f, ahorro.getSaldo(), 0.01);
        assertEquals(1, ahorro.getNumeroConsignaciones());
        assertEquals(1, ahorro.getNumeroRetiros());

        // Corriente: tras extracto: 500 + 500*(0.02/12) ≈ 500.8333 ; sobregiro = 0
        CuentaCorriente corriente = new CuentaCorriente(5000f, 0.02f);
        controller.retirar(corriente, 6000f);    // saldo=0, sobregiro=1000
        controller.consignar(corriente, 1500f);  // cubre 1000, deja saldo=500
        controller.generarExtracto(corriente);   // + interés mensual

        assertEquals(0f, corriente.getSobregiro(), 0.01);
        assertEquals(500.8333f, corriente.getSaldo(), 0.01);
    }
}