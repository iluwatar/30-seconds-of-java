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

import static org.junit.jupiter.api.Assertions.assertEquals;

import math.PointSnippet.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PointSnippetTest {

  private Point pointX2Y3;
  private Point pointX7Y20;

  @BeforeEach
  void setUp() {
    pointX2Y3 = new Point(2, 3);
    pointX7Y20 = new Point(7, 15);
  }

  @Test
  void shouldFindDistanceBetweenTwoPoints() {
    assertEquals(13.0, pointX2Y3.distanceTo(pointX7Y20));
  }

  @Test
  void shouldFindAngleInRadiansWithXAxisAgainstLineJoiningTwoPoints() {
    assertEquals(1.176, pointX7Y20.angleWithXAxis(pointX2Y3), 0.01d);
    assertEquals(0.982, pointX2Y3.angleWithXAxis(new Point(0, 0)), 0.01d);
  }
}