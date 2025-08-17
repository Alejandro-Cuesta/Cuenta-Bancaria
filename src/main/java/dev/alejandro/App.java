package dev.alejandro;

import dev.alejandro.controller.CuentaController;
import dev.alejandro.model.CuentaAhorros;
import dev.alejandro.model.CuentaCorriente;

public class App {
    public static void main(String[] args) {
        CuentaController controller = new CuentaController();

        //Cuenta de Ahorros
        CuentaAhorros ahorro = new CuentaAhorros(15000, 5);
        controller.consignar(ahorro, 2000);
        controller.retirar(ahorro, 500);
        controller.generarExtracto(ahorro);
        controller.imprimir(ahorro);

        System.out.println("");

        //Cuenta Corriente
        CuentaCorriente corriente = new CuentaCorriente(5000, 3);
        controller.retirar(corriente, 6000); //genera sobregiro
        controller.consignar(corriente, 2000); //reduce sobregiro
        controller.generarExtracto(corriente);
        controller.imprimir(corriente);
    }
}