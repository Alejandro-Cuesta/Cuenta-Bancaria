package dev.alejandro.service;

import dev.alejandro.model.CuentaAhorros;
import dev.alejandro.model.CuentaCorriente;

public class CuentaService {

    //CuentaAhorros 
    public void consignarSiActiva(CuentaAhorros cuenta, float monto) {
        if (cuenta.isActiva()) {
            cuenta.consignar(monto);
        }
    }

    public void retirarSiActiva(CuentaAhorros cuenta, float monto) {
        if (cuenta.isActiva()) {
            cuenta.retirar(monto);
        }
    }

    public void generarExtracto(CuentaAhorros cuenta) {
        cuenta.extractoMensual();
    }

    public String obtenerEstadoAhorro(CuentaAhorros cuenta) {
        return "Saldo: " + cuenta.getSaldo() +
               ", Comisión: " + cuenta.getComisionMensual() +
               ", Transacciones: " + (cuenta.getNumeroConsignaciones() + cuenta.getNumeroRetiros());
    }

    //CuentaCorriente
    public void consignarCorriente(CuentaCorriente cuenta, float monto) {
        cuenta.consignar(monto);
    }

    public void retirarCorriente(CuentaCorriente cuenta, float monto) {
        cuenta.retirar(monto);
    }

    public String obtenerEstadoCorriente(CuentaCorriente cuenta) {
        return "Saldo: " + cuenta.getSaldo() +
               ", Comisión: " + cuenta.getComisionMensual() +
               ", Transacciones: " + (cuenta.getNumeroConsignaciones() + cuenta.getNumeroRetiros()) +
               ", Sobregiro: " + cuenta.getSobregiro();
    }

    public void generarExtracto(CuentaCorriente cuenta) {
        cuenta.extractoMensual();
    }
}
