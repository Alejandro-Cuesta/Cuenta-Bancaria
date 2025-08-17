package dev.alejandro.model;

public abstract class Cuenta {
    protected float saldo;
    protected int numeroConsignaciones = 0;
    protected int numeroRetiros = 0;
    protected float tasaAnual;
    protected float comisionMensual = 0f;

    public Cuenta(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }

    public void consignar(float monto) {
        saldo += monto;
        numeroConsignaciones++;
    }

    public void retirar(float monto) {
        if (monto <= saldo) {
            saldo -= monto;
            numeroRetiros++;
        } else {
            System.out.println("Fondos insuficientes");
        }
    }

    public void calcularInteres() {
        saldo += saldo * (tasaAnual / 12);
    }

    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularInteres();
        comisionMensual = 0; // Reset mensual
    }

    public float getSaldo() {
        return saldo;
    }

    public int getNumeroConsignaciones() {
        return numeroConsignaciones;
    }

    public int getNumeroRetiros() {
        return numeroRetiros;
    }

    public float getComisionMensual() {
        return comisionMensual;
    }
}