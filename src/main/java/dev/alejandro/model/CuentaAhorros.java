package dev.alejandro.model;

public class CuentaAhorros extends Cuenta {
    private boolean activa;

    public CuentaAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.activa = saldo >= 10000;
    }

    @Override
    public void consignar(float monto) {
        if (activa) super.consignar(monto);
    }

    @Override
    public void retirar(float monto) {
        if (activa) super.retirar(monto);
    }

    @Override
    public void extractoMensual() {
        if (numeroRetiros > 4) {
            comisionMensual += (numeroRetiros - 4) * 1000;
        }
        super.extractoMensual();
        activa = saldo >= 10000;
    }

    public boolean isActiva() {
        return activa;
    }
}