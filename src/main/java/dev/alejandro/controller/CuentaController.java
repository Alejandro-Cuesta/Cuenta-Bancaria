package dev.alejandro.controller;

import dev.alejandro.model.CuentaAhorros;
import dev.alejandro.model.CuentaCorriente;
import dev.alejandro.service.CuentaService;

public class CuentaController {
    private final CuentaService service = new CuentaService();

    //Operaciones CuentaAhorros
    public void consignar(CuentaAhorros cuenta, float monto) {
        service.consignarSiActiva(cuenta, monto);
    }

    public void retirar(CuentaAhorros cuenta, float monto) {
        service.retirarSiActiva(cuenta, monto);
    }

    public void generarExtracto(CuentaAhorros cuenta) {
        service.generarExtracto(cuenta);
    }

    public void imprimir(CuentaAhorros cuenta) {
        System.out.println(service.obtenerEstadoAhorro(cuenta));
    }

    //Operaciones CuentaCorriente
    public void consignar(CuentaCorriente cuenta, float monto) {
        service.consignarCorriente(cuenta, monto);
    }

    public void retirar(CuentaCorriente cuenta, float monto) {
        service.retirarCorriente(cuenta, monto);
    }

    public void generarExtracto(CuentaCorriente cuenta) {
        service.generarExtracto(cuenta);
    }

    public void imprimir(CuentaCorriente cuenta) {
        System.out.println(service.obtenerEstadoCorriente(cuenta));
    }
}