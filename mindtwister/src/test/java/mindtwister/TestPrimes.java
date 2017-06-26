package mindtwister;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;

import org.junit.Test;

import com.mindtwister.Factor;

public class TestPrimes {

  @Test
  public void testFactors() {
    Collection<Integer> primes = Factor.findPrimeNumbers(8);
    assertThat(primes.toString()).isEqualTo("[2, 3, 5, 7, 11, 13, 17, 19]");
    
    primes = Factor.findPrimeNumbers(29);
    assertThat(primes.toString()).isEqualTo("[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109]");
  
    primes = Factor.findPrimeNumbers(46);
    assertThat(primes.toString()).isEqualTo("[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199]");
  
  }
  
  @Test
  public void testSieve() {
    assertThat(Factor.findPrimeNumbersBySieve(20).toString()).isEqualTo("[2, 3, 5, 7, 11, 13, 17, 19]");
    
    assertThat(Factor.findPrimeNumbersBySieve(110).toString()).isEqualTo("[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109]");
    
    assertThat(Factor.findPrimeNumbersBySieve(200).toString()).isEqualTo("[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199]");
  
    System.out.println(Factor.findPrimeNumbersBySieve(100000).toString());
  }
}
