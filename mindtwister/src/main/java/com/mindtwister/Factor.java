package com.mindtwister;

import java.util.ArrayList;
import java.util.Collection;

public class Factor {

  /**
   * Find factors of the given parameter
   * 
   * @param num
   * @return
   */
  public static Collection<Integer> factors(int num) {
    Collection<Integer> factors = new ArrayList<Integer>();
    
    for (int i = 1; i <= num; i++) {
      if (i == 1 || i == num) {
        factors.add(i);
      }
      else if (num % i == 0) {
        factors.add(i);
      }
    }
    return factors;
  }
  
  /**
   * Find the first prime numbers starting from 1 .... N (until the given count is reached)
   * 
   * @param count
   * @return
   */
  public static Collection<Integer> findPrimeNumbers(int count) {
    Collection<Integer> primes = new ArrayList<Integer>();
    for (int i = 1; i < Integer.MAX_VALUE; i++) {
      if (factors(i).size() == 2) {
        primes.add(i);
      }
      
      if (primes.size() == count) break;
    }
    return primes;
  }
  
  /**
   * Using Sieve find all prime numbers from between 1 .... ceiling
   * 
   * @param ceiling
   * @return
   */
  public static Collection<Integer> findPrimeNumbersBySieve(int ceiling) {
    Collection<Integer> primes = new ArrayList<Integer>();
    Collection<Integer> composites = new ArrayList<Integer>();
    composites.add(1);
    
    for (int i = 1; i <= ceiling; i++) {
      if (!composites.contains(i)) {
        primes.add(i);
        for (int k = i; k <= ceiling; k+=i) {
          composites.add(k);
        }
      }
    }
    
    return primes;
  }
}
