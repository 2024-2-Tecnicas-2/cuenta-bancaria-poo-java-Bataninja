package com.mycompany.cuenta.bancaria.poo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class CuentaBancariaTest {
    // TODO Adiciona tus pruebas unitarias aquí.
    // Los métodos deben estar anotados con la anotación @Test. Por ejemplo:
    //
    // @Test
    // public void miPrueba() {
    //      double valorEsperado = 10;
    //      double valorActual = Calculadora.calcular(7, 3, '+');
    //      assertEquals(valorEsperado, valorActual);
    // }
    private CuentaBancaria cuenta1, cuenta2;
    
    @BeforeEach
    void setUp() {
        cuenta1 = new CuentaBancaria("Jhon Doe", "506232050", 150000.0);
        cuenta2 = new CuentaBancaria("Maria Doe", "505232050", 999.0);
    }

    @Test
    void testGetTitularCuenta1() {
        assertEquals("Jhon Doe", cuenta1.getTitular(), "El titular de la cuenta1 debería ser 'Jhon Doe'");
    }

    @Test
    void testGetTitularCuenta2() {
        assertEquals("Maria Doe", cuenta2.getTitular(), "El titular de la cuenta2 debería ser 'Maria Doe'");
    }
    
    @Test
    void testSetTitularCuenta1() {
        cuenta1.setTitular("Carlos Guevara");
        assertEquals("Carlos Guevara", cuenta1.getTitular(), "El titular de la cuenta1 debería ser 'Nuevo Titular'");
    }
    
    @Test
    void testSetTitularCuenta2() {
        cuenta2.setTitular("");
        assertEquals("", cuenta2.getTitular(), "El titular de la cuenta1 debería ser 'Nuevo Titular'");
    }
    
    @Test
    void testGetNumeroCuenta1() {
        assertEquals("506232050", cuenta1.getNumeroCuenta(), "El número de cuenta debería ser '506232050'");
    }

    @Test
    void testGetNumeroCuenta2() {
        assertEquals("505232050", cuenta2.getNumeroCuenta(), "El número de cuenta2 debería ser '505232050'");
    }
    
    @Test
    void testGetSaldoCuenta1() {
        assertEquals(150000.0, cuenta1.getSaldo(), "El titular de la cuenta1 debería ser '150000'");
    }

    @Test
    void testGetSaldoCuenta2() {
        assertEquals(999.0, cuenta2.getSaldo(), "El titular de la cuenta2 debería ser '999'");
    }
    
    @Test
    void testIngresarCuenta1() throws Exception {
        cuenta1.ingresar(500.0);
        assertEquals(150500.0, cuenta1.getSaldo(),"El saldo de la cuenta1 debería ser '150500'");
    }

    @Test
    void testIngresarCuenta2() {
        try {
            cuenta2.ingresar(-100.0);
            fail("Debía arrojar excepcion.");
        } catch (Exception e) {
            assertEquals("Cantidad ingresada invalida.", e.getMessage());
        }
    }
    
    @Test
    void testRetirarCuenta1() throws Exception {
        cuenta1.retirar(150000);
        assertEquals(0, cuenta1.getSaldo(),"El saldo de la cuenta1 debería ser '0'");
    }

    @Test
    void testRetirarCuenta2() {
        try {
            cuenta2.retirar(999999.0);
            fail("Debía arrojar excepcion.");
        } catch (Exception e) {
            assertEquals("Fondos insuficientes o cantidad ingresada invalida.", e.getMessage());
        }
    }
    
    @Test
    void testCalcularInteresesCuenta1() {
        double interes = cuenta1.getSaldo()+ (cuenta1.getSaldo()*1.5/100);
        assertEquals(interes, cuenta1.calcularIntereses(), "El interés de la cuenta1 debería ser '"+interes+"'");
    }

    @Test
    void testCalcularInteresesCuenta2() {
        double interes = cuenta2.getSaldo() + (cuenta2.getSaldo()*1.5/100);
        assertEquals(interes, cuenta2.calcularIntereses(), "El interés de la cuenta1 debería ser '"+interes+"'");
    }
    
    @Test
    void testSetTipoInteresCuenta1()throws Exception {
            cuenta1.setTipoInteres(10);
            double interes = cuenta1.getSaldo() + (cuenta1.getSaldo()*10/100);
            assertEquals(interes, cuenta1.calcularIntereses(),"El interés de la cuenta1 debería ser '"+interes+"'");
    }

    @Test
    void testSetTipoInteresCuenta2() {
        try {
            cuenta2.setTipoInteres(-5);
            fail("Debía arrojar excepcion.");
        } catch (Exception e) {
            assertEquals("Tipo de interés invalido.", e.getMessage());
        }
    }
    
}
