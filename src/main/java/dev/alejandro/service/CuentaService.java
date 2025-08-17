package dev.alejandro.service;

import dev.alejandro.model.Cuenta;
import dev.alejandro.model.CuentaAhorros;
import dev.alejandro.model.CuentaCorriente;

public class CuentaService {

    public void consignar(Cuenta cuenta, float monto) {
        cuenta.consignar(monto);
    }

    public void retirar(Cuenta cuenta, float monto) {
        cuenta.retirar(monto);
    }

    public void generarExtracto(Cuenta cuenta) {
        cuenta.extractoMensual();
    }

    public String obtenerEstado(Cuenta cuenta) {
        String base = "Saldo: " + cuenta.getSaldo() +
                      ", Comisión: " + cuenta.getComisionMensual() +
                      ", Transacciones: " + (cuenta.getNumeroConsignaciones() + cuenta.getNumeroRetiros());

        if (cuenta instanceof CuentaCorriente cc) {
            base += ", Sobregiro: " + cc.getSobregiro();
        } else if (cuenta instanceof CuentaAhorros ca) {
            base += ", Activa: " + ca.isActiva();
        }

        return base;
    }
}