/*
 * MIT License
 *
 * Copyright (c) 2017-2022 Ilkka Seppälä
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

import org.junit.jupiter.api.Test;

/*
 * Tests for CubeRootSnippet class.
 *
 */
class CubeRootSnippetTest {
  /**
   * Tests for {@link CubeRootSnippet#cubeRoot(double)}.
   */
  @Test
  void testCubeRoot() {
    assertEquals(0, CubeRootSnippet.cubeRoot(0), 0.0001);
    assertEquals(1, CubeRootSnippet.cubeRoot(1), 0.0001);
    assertEquals(2, CubeRootSnippet.cubeRoot(8), 0.0001);
    assertEquals(3, CubeRootSnippet.cubeRoot(27), 0.0001);
    assertEquals(4, CubeRootSnippet.cubeRoot(64), 0.0001);
    assertEquals(5, CubeRootSnippet.cubeRoot(125), 0.0001);
    assertEquals(6, CubeRootSnippet.cubeRoot(216), 0.0001);
    assertEquals(7, CubeRootSnippet.cubeRoot(343), 0.0001);
    assertEquals(8, CubeRootSnippet.cubeRoot(512), 0.0001);
    assertEquals(9, CubeRootSnippet.cubeRoot(729), 0.0001);
    assertEquals(10, CubeRootSnippet.cubeRoot(1000), 0.0001);
  }

  /**
   * Tests for {@link CubeRootSnippet#recursiveCubeRoot(double)}.
   */
  @Test
  void testRecursiveCubeRoot() {
    assertEquals(0, CubeRootSnippet.recursiveCubeRoot(0), 0.0001);
    assertEquals(1, CubeRootSnippet.recursiveCubeRoot(1), 0.0001);
    assertEquals(2, CubeRootSnippet.recursiveCubeRoot(8), 0.0001);
    assertEquals(3, CubeRootSnippet.recursiveCubeRoot(27), 0.0001);
    assertEquals(4, CubeRootSnippet.recursiveCubeRoot(64), 0.0001);
    assertEquals(5, CubeRootSnippet.recursiveCubeRoot(125), 0.0001);
    assertEquals(6, CubeRootSnippet.recursiveCubeRoot(216), 0.0001);
    assertEquals(7, CubeRootSnippet.recursiveCubeRoot(343), 0.0001);
    assertEquals(8, CubeRootSnippet.recursiveCubeRoot(512), 0.0001);
    assertEquals(9, CubeRootSnippet.recursiveCubeRoot(729), 0.0001);
    assertEquals(10, CubeRootSnippet.recursiveCubeRoot(1000), 0.0001);
  }
}
