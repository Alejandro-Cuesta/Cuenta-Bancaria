package dev.alejandro.controller;

import dev.alejandro.model.Cuenta;
import dev.alejandro.service.CuentaService;

public class CuentaController {
    private final CuentaService service = new CuentaService();

    public void consignar(Cuenta cuenta, float monto) {
        service.consignar(cuenta, monto);
    }

    public void retirar(Cuenta cuenta, float monto) {
        service.retirar(cuenta, monto);
    }

    public void generarExtracto(Cuenta cuenta) {
        service.generarExtracto(cuenta);
    }

    public void imprimir(Cuenta cuenta) {
        System.out.println(service.obtenerEstado(cuenta));
    }
}