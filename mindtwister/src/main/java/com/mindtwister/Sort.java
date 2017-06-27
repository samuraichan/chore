package com.mindtwister;

public class Sort {

  
  public static int[] simpleSort(int [] nums) {
    boolean swapped = true;
    while(swapped) {
      swapped = false;
      
      for (int i = 0; i < nums.length; i++) {
        if ((i+1) < nums.length && nums[i] > nums[i+1]) {
          int temp = nums[i+1];
          nums[i+1] = nums[i];
          nums[i] = temp;
          swapped = true;
        }
      }
    }
    
    return nums;
  }
  
}
