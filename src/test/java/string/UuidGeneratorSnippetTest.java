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

package string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UuidGeneratorSnippetTest {

  @Test
  void generateUUID_shouldReturnValidUUID() {
    String uuid = UuidGeneratorSnippet.generateUUID();
    assertTrue(UuidGeneratorSnippet.isValidUUID(uuid));
  }

  @Test
  void isValidUUID_shouldReturnTrueForValidUUID() {
    assertTrue(UuidGeneratorSnippet.isValidUUID("123e4567-e89b-12d3-a456-426614174000"));
  }

  @Test
  void isValidUUID_shouldReturnFalseForInvalidUUID() {
    assertFalse(UuidGeneratorSnippet.isValidUUID("not-a-uuid"));
    assertFalse(UuidGeneratorSnippet.isValidUUID("1234"));
  }

}