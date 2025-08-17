package dev.alejandro.model;

public class CuentaCorriente extends Cuenta {
    private float sobregiro = 0f;

    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
    }

    @Override
    public void retirar(float monto) {
        if (monto <= saldo) {
            super.retirar(monto);
        } else {
            sobregiro += monto - saldo;
            saldo = 0;
            numeroRetiros++;
        }
    }

    @Override
    public void consignar(float monto) {
        if (sobregiro > 0) {
            if (monto >= sobregiro) {
                monto -= sobregiro;
                sobregiro = 0;
            } else {
                sobregiro -= monto;
                monto = 0;
            }
        }
        super.consignar(monto);
    }

    public float getSobregiro() {
        return sobregiro;
    }
}