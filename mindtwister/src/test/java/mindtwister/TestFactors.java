package mindtwister;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

import com.mindtwister.Factorial;
import com.mindtwister.Factor;

public class TestFactors {

  @Test
  public void testFactors() {
    assertThat(Factor.factors(8)).isNotEmpty();
  }
}
