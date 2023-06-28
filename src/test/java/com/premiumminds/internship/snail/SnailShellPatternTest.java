package com.premiumminds.internship.snail;

import static org.junit.Assert.assertArrayEquals;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by aamado on 05-05-2023.
 */
@RunWith(JUnit4.class)
public class SnailShellPatternTest {

  /**
   * The corresponding implementations to test.
   *
   * If you want, you can make others :)
   *
   */
  public SnailShellPatternTest() {
  };


  /**
   *Test for empty matrix
   */
  @Test
  public void ScreenLockinPatternTestFirst0Length2Test()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = new int[0][0];
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { };
    assertArrayEquals(result, expected);
  }

  /**
   *Test for matrix 1x1
   */
  @Test
  public void ScreenLockinPatternTestFirst1Length2Test()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1 };
    assertArrayEquals(result, expected);
  }

  /**
   *Test for matrix 2x2
   */
  @Test
  public void ScreenLockinPatternTestFirst2Length2Test()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2 }, { 4, 3 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4 };
    assertArrayEquals(result, expected);
  }

  /**
   *Test for matrix 3x3
   */
  @Test
  public void ScreenLockinPatternTestFirst3Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    assertArrayEquals(result, expected);
  }

  /**
   *Test for matrix 5x5
   */
  @Test
  public void ScreenLockinPatternTestFirst5Length2Test()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3, 4, 5 },
                       { 16, 17, 18, 19, 6 },
                       { 15, 24, 25, 20, 7 },
                       { 14, 23, 22, 21, 8 },
                       { 13, 12, 11, 10, 9 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
    assertArrayEquals(result, expected);
  }

  /**
   *Test for matrix 8x8
   */
  @Test
  public void ScreenLockinPatternTestFirst8Length2Test()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3, 4, 5, 6, 7, 8 },
                      { 28, 29, 30, 31, 32, 33, 34, 9 },
                      { 27, 48, 49, 50, 51, 52, 35, 10 },
                      { 26, 47, 60, 61, 62, 53, 36, 11 },
                      { 25, 46, 59, 64, 63, 54, 37, 12 },
                      { 24, 45, 58, 57, 56, 55, 38, 13 },
                      { 23, 44, 43, 42, 41, 40, 39, 14 },
                      { 22, 21, 20, 19, 18, 17, 16, 15 }};
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
                      27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
                      51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64};
    assertArrayEquals(result, expected);
  }

  /**
   *Test for matrix 3x3 with negative numbers
   */
  @Test
  public void ScreenLockinPatternTestFirstNeg3Length2Test()
          throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { -1, -2, -3 }, { -8, -9, -4 }, { -7, -6, -5 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { -1, -2, -3, -4, -5, -6, -7, -8, -9 };
    assertArrayEquals(result, expected);
  }

}