package com.premiumminds.internship.snail;

import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Arrays;

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

      int [] empty = new int[0];

      if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return empty;
      }

      int n =  matrix.length;
      int up = 0;                   //upper line of matrix
      int down = n-1;               //lower line of matrix
      int left = 0;                 //left line of matrix
      int right = n-1;              //right line of matrix
      int i;
      int j = 0;
      int nlaps = 0;                //counts the number of laps/cycles
      int [] result = new int[n*n]; //array with the resulted snail path

      while(true){

        if(j == n*n){ break;}               //breaks the cycle when the snail path is completed
        for(i = 0; left+i <= right; i++){   //cycle to retrieve the upper row
          result[j] = matrix[up][i+nlaps];
          j++;
        }
        up++;

        if(j == n*n){ break;}               //breaks the cycle when the snail path is completed
        for(i = 0; up+i <= down; i++){      //cycle to retrieve the right column
          result[j] = matrix[i+up][right];
          j++;
        }
        right--;

        if(j == n*n){ break;}               //breaks the cycle when the snail path is completed
        for(i = n-1; i-nlaps > nlaps; i--){ //cycle to retrieve the lower row
          result[j] = matrix[down][i-up];
          j++;
        }
        down--;

        if(j == n*n){ break;}                 //breaks the cycle when the snail path is completed
        for(i = n-1; i-nlaps > nlaps+1; i--){ //cycle to retrieve the left column
          result[j] = matrix[i-up][left];
          j++;
        }
        left++;

        nlaps++;
      }

    return result;
    });
  };
}
