
package dev.alejandro;

import dev.alejandro.controller.CuentaController;
import dev.alejandro.model.CuentaAhorros;
import dev.alejandro.model.CuentaCorriente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    void flujoPrincipalCuentas() {
        CuentaController controller = new CuentaController();

        CuentaAhorros ahorro = new CuentaAhorros(15000f, 0.03f);
        CuentaCorriente corriente = new CuentaCorriente(5000f, 0.02f);

        // Ahorros
        controller.consignar(ahorro, 2000f);
        controller.retirar(ahorro, 500f);
        controller.generarExtracto(ahorro);

        assertEquals(true, ahorro.isActiva());
        assertEquals(17050f, ahorro.getSaldo(), 0.1);

        // Corriente
        controller.retirar(corriente, 6000f);
        controller.consignar(corriente, 1500f);
        controller.generarExtracto(corriente);

        assertEquals(500f, corriente.getSaldo(), 0.1);
        assertEquals(500f, corriente.getSobregiro(), 0.1);
    }
}