package algorithm;

import java.util.Arrays;

/*
 * 30 Seconds of Java code library
 *
 */
public class CountingSortSnippet {

  /**
   * Sort an array having zero or positive number with countingSort algorithm.
   *
   * @param arr array to sort
   */
  public static void countingSort(int[] arr) {
    var max = Arrays.stream(arr).max().getAsInt();

    var count = new int[max + 1];

    for (var num : arr) {
      count[num]++;
    }

    for (var i = 0; i <= max; i++) {
      count[i] += count[i - 1];
    }

    var sorted = new int[arr.length];
    for (var i = arr.length - 1; i >= 0; i--) {
      var cur = arr[i];
      sorted[count[cur] - 1] = cur;
      count[cur] -= 1;
    }

    int index = 0;
    for (var num : sorted) {
      arr[index++] = num;
    }
  }
}
