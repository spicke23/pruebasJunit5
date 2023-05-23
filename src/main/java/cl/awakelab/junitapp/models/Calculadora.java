package cl.awakelab.junitapp.models;

public class Calculadora {

  // add "sumar, adicion"
  // el clean code
  public int add(int operand1, int operand2) {
    return operand1 + operand2;
  }
  
  public int subtract(int operand1, int operand2) {
    return operand1 - operand2;
  }
  
  public int multiply(int operand1, int operand2) {
    return operand1 * operand2;
  }
  
  public int divide(int dividend, int divisor) {
    
    if(divisor == 0) {
      throw new IllegalArgumentException("Divisor cannot be zero");
    }
    return dividend / divisor;
  }
  
}
