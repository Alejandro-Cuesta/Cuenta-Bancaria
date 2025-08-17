package dev.alejandro.model;

public class Cuenta {
    protected float saldo;
    protected int numeroConsignaciones = 0;
    protected int numeroRetiros = 0;
    protected float tasaAnual;
    protected float comisionMensual = 0;

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
        }
    }

    public void calcularInteresMensual() {
        float interes = saldo * (tasaAnual / 12 / 100);
        saldo += interes;
    }

    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularInteresMensual();
    }

    // Getters
    public float getSaldo() { return saldo; }
    public int getNumeroConsignaciones() { return numeroConsignaciones; }
    public int getNumeroRetiros() { return numeroRetiros; }
    public float getComisionMensual() { return comisionMensual; }
}
