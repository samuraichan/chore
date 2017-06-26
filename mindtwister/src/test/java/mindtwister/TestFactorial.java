package mindtwister;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

import com.mindtwister.Factorial;

public class TestFactorial {

  @Test
  public void testFactorial() {
    assertThat(Factorial.doFactorial(4)).isEqualTo(24);
    assertThat(Factorial.doFactorial(7)).isEqualTo(5040);
    assertThat(Factorial.doFactorial(1)).isEqualTo(1);
    assertThat(Factorial.doFactorial(10)).isEqualTo(3628800);
  }
  
  @Test
  public void testFactorialRec() {
    assertThat(Factorial.doFactorialRec(4)).isEqualTo(24);
    assertThat(Factorial.doFactorialRec(7)).isEqualTo(5040);
    assertThat(Factorial.doFactorialRec(1)).isEqualTo(1);
    assertThat(Factorial.doFactorialRec(10)).isEqualTo(3628800);
  }
}
