package com.mycompany.cuenta.bancaria.poo;

public class CuentaBancaria {
    private String titular;
    private String numeroCuenta;
    private double saldo;
    private double tipoInteres;

    public CuentaBancaria(String titular, String numeroCuenta, double saldo) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.tipoInteres = 1.5;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public void ingresar(double cantidad) throws Exception{
        if(cantidad > 0)
            saldo += cantidad;
        else
            throw new Exception("Cantidad ingresada invalida.");
    }
    
    public void retirar(double cantidad) throws Exception{
        if(cantidad > 0 && saldo >= cantidad)
            saldo -= cantidad;
        else
            throw new Exception("Fondos insuficientes o cantidad ingresada invalida.");
    }
    
    public double calcularIntereses(){
        return saldo + (saldo*tipoInteres/100);
    }

    public void setTipoInteres(double tipoInteres) throws Exception{
        if(tipoInteres >= 0 && tipoInteres <= 10)
            this.tipoInteres = tipoInteres;
        else
            throw new Exception("Tipo de interés invalido.");
    }
    
  

   
}
