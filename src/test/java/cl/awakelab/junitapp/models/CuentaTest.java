package cl.awakelab.junitapp.models;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CuentaTest {

  @Test
  void testNombreCuenta() {
    
    Cuenta cuenta = new Cuenta("Miguel", new BigDecimal("1000.123456"));
    // Lo esperado
    String esperado = "Miguel";
    String real = cuenta.getPersona();
    
    // Assertions.assertEquals(esperado, real);
    assertEquals(esperado, real);
    
  }
  
  @Test
  void testSaldoCuenta() {
    
    Cuenta cuenta = new Cuenta("Miguel", new BigDecimal("1000.123456"));
    
    double esperado = 1000.123456;
    BigDecimal real = cuenta.getSaldo();
    
    // assertEquals(1000.123456, cuenta.getSaldo().doubleValue());
    assertEquals(esperado, real.doubleValue());
  }
  
  @Test
  void testReferenciaCuenta() {
    
    Cuenta cuenta = new Cuenta("Miguel", new BigDecimal("1000.123456"));
    Cuenta cuenta2 = new Cuenta("Miguel", new BigDecimal("1000.123456"));
    
    assertEquals(cuenta2, cuenta);
    // En este caso cuenta y cuenta 2 son dos objetos diferentes de la clase Cuenta
    // Aunque tienen los mismos valores, se consideran diferentes por que tienen referencias en memoria distintas.
    
  }
}
