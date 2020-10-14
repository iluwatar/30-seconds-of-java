/*
 * MIT License
 *
 * Copyright (c) 2017-2019 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package math;

import java.util.Objects;

/*
 * 30 Seconds of Java code library
 *
 */
public class PointSnippet {

  /**
   * Sample program to demo the usage of point class.
   *
   * @param args not used
   */
  public static void main(String[] args) {
    final var _1_2 = new Point(1, 2);
    final var _4_6 = new Point(4, 6);
    System.out.println("Distance from " + _1_2 + " and " + _4_6 + " is " + _1_2.distanceTo(_4_6));
    System.out.println(
        "Line joining " + _1_2 + " and " + _4_6 + " makes angle " + _4_6.angleWithXAxis(_1_2)
            + " radians with X-axis");
  }

  public static class Point extends Pair<Integer, Integer> {

    public Point(Integer x, Integer y) {
      super(x, y);
    }

    public Integer getX() {
      return t1;
    }

    public Integer getY() {
      return t2;
    }

    public double distanceTo(Point other) {
      return Math.sqrt(square(deltaX(other)) + square(deltaY(other)));
    }

    public double angleWithXAxis(Point other) {
      return Math.atan2(deltaY(other), deltaX(other));
    }

    @Override
    public String toString() {
      return "(" + getX() + ", " + getY() + ")";
    }

    private int deltaX(Point other) {
      return getX() - other.getX();
    }

    private int deltaY(Point other) {
      return getY() - other.getY();
    }

    private static int square(int x) {
      return x * x;
    }
  }

  public static class Pair<T1, T2> {

    protected final T1 t1;
    protected final T2 t2;

    public Pair(T1 t1, T2 t2) {
      this.t1 = t1;
      this.t2 = t2;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Pair<?, ?> pair = (Pair<?, ?>) o;
      return Objects.equals(t1, pair.t1)
          && Objects.equals(t2, pair.t2);
    }

    @Override
    public int hashCode() {
      return Objects.hash(t1, t2);
    }
  }
}
