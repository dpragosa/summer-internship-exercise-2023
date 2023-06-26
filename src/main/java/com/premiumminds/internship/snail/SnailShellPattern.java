package com.premiumminds.internship.snail;

import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by aamado on 05-05-2023.
 */
class SnailShellPattern implements ISnailShellPattern {
  private ExecutorService executor
    = Executors.newSingleThreadExecutor();
  /**
   * Method to get snailshell pattern
   * 
   * @param matrix matrix of numbers to go through
   * @return order array of values thar represent a snail shell pattern
   */
  public Future<int[]> getSnailShell(int[][] matrix) {

    return executor.submit(() -> {

      int n =  matrix.length;
      int up = 0;
      int down = n-1;
      int left = 0;
      int right = n-1;
      int i;
      int j = 0;
      int aux = 0;
      int [] result = new int[n*n];

    while(true){

      if(j == n*n){ break;}
      for(i = 0; i < n-up; i++){
        result[j] = matrix[up][i+aux];
        j++;
      }
      up++;


      if(j == n*n){ break;}
      for(i = 0; i < right-aux; i++){
        result[j] = matrix[i+up][right];
        j++;
      }
      right--;

      if(j == n*n){ break;}
      for(i = n-1; i-aux > aux; i--){
        result[j] = matrix[down][i-up];
        j++;
      }
      down--;

      if(j == n*n){ break;}
      for(i = n-1; i-aux > aux; i--){
        result[j] = matrix[i-up][left];
        j++;
      }
      left++;

      aux++;
    }

      return result;
    });
  };
}
