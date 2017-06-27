package mindtwister;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

import com.mindtwister.Sort;

import ch.qos.logback.core.net.SyslogOutputStream;

public class TestSimpleSort {

  @Test
  public void testBubbleSort() {
    int [] nums = {5, 1, 4, 2, 8};
    assertThat(Arrays.toString(Sort.simpleSort(nums))).isEqualTo("[1, 2, 4, 5, 8]");
    
    int [] x = {11, 12, 22, 25, 34, 64, 90};
    assertThat(Arrays.toString(Sort.simpleSort(x))).isEqualTo("[11, 12, 22, 25, 34, 64, 90]");
    
    int [] y = {90, 64, 34, 25, 22, 12, 11};
    assertThat(Arrays.toString(Sort.simpleSort(y))).isEqualTo("[11, 12, 22, 25, 34, 64, 90]");
    
    int [] z = {-90, 164, 4, -25, 24, 12, 11};
    assertThat(Arrays.toString(Sort.simpleSort(z))).isEqualTo("[-90, -25, 4, 11, 12, 24, 164]");
    
    String [] chars = {"5", "50", "56"};
    Arrays.sort(chars);
    System.out.println(Arrays.toString(chars));
    
    Integer[] VALUES = {420, 42, 423};
    Arrays.sort(VALUES, new Comparator<Integer>() {

      @Override
      public int compare(Integer lhs, Integer rhs) {
          String v1 = lhs.toString();
          String v2 = rhs.toString();

          return (v1 + v2).compareTo(v2 + v1);
      }
    });
    System.out.println(Arrays.toString(VALUES));
    
    String value = "";
    for (int i = VALUES.length - 1; i >= 0; i--) {
      value += VALUES[i];
    }
    System.out.println(Integer.valueOf(value));
  
  }
}
