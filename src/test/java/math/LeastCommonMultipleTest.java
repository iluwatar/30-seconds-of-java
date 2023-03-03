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
  * Tests for 30 Seconds of Java code library
  *
  */
 class LeastCommonMultipleSnippetTest {
   /**
    * Tests for {@link LeastCommonMultipleSnippet#lcm(int, int)}.
    */
   @Test
   void testLcm() {
     assertEquals(4, LeastCommonMultipleSnippet.lcm(2, 4));
     assertEquals(10, LeastCommonMultipleSnippet.lcm(2, 5));
     assertEquals(72, LeastCommonMultipleSnippet.lcm(18, 24));
     assertEquals(7, LeastCommonMultipleSnippet.lcm(7, 7));
   }
 }
