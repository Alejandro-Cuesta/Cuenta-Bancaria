package dev.alejandro;

import dev.alejandro.controller.CuentaController;
import dev.alejandro.model.CuentaAhorros;
import dev.alejandro.model.CuentaCorriente;

public class App {
    public static void main(String[] args) {
        CuentaController controller = new CuentaController();

        //Crear cuentas
        CuentaAhorros ahorro = new CuentaAhorros(15000f, 0.03f);
        CuentaCorriente corriente = new CuentaCorriente(5000f, 0.02f);

        //Operaciones en cuenta de ahorros
        controller.consignar(ahorro, 2000f);
        controller.retirar(ahorro, 500f);
        controller.generarExtracto(ahorro);
        controller.imprimir(ahorro);

        //Operaciones en cuenta corriente
        controller.retirar(corriente, 6000f); //genera sobregiro
        controller.consignar(corriente, 1500f);
        controller.generarExtracto(corriente);
        controller.imprimir(corriente);
    }
}