package com.mindtwister;

public class Factorial {

  public static int doFactorial(int num) {
    int value = num;
    for (int i = num; i > 1; i--) {
      value = value * (i - 1);
    }
    
    return value;  
  }
  
  public static int doFactorialRec(int num) {
    if (num == 1) {
      return num;
    }
    else {
      return num * doFactorialRec(num - 1); 
    }
  }
}
