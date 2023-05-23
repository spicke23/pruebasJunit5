package cl.awakelab.junitapp.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

  private Calculadora calculator;
  
  @BeforeAll
  static void setUpAll() {
    System.out.println("Configuración inicial para todas las pruebas");
  }
  
  @BeforeEach
  void setUp() {
    System.out.println("Configuración específica antes de cada prueba");
    calculator = new Calculadora();
  }
  
  @Test
  public void testAdd() {
    assertEquals(5, calculator.add(2, 3));
  }
  
  @Test
  public void testSubtract() {
    assertEquals(2, calculator.subtract(5, 3));
  }
  
  @Test
  public void testMultiply() {
    assertEquals(15, calculator.multiply(3, 5));
  }
  
  @Test
  public void testDivide() {
    assertEquals(2, calculator.divide(6, 3));
  }
  
  @Test
  public void testDivideByZero() {
    assertThrows(IllegalArgumentException.class, () -> {
      calculator.divide(10, 0);
    });
  }
  
  @AfterEach
  void tearDown() {
    calculator = null;
    System.out.println("Realizar tareas de limpieza después de cada prueba");
  }
  
  @AfterAll
  static void tearDownAll() {
    System.out.println("Tareas de limpieza finales despues de todas las pruebas");
  }
  
  
}
