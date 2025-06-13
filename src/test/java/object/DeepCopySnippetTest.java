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

package object;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.io.Serializable;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link DeepCopySnippet}.
 */
public class DeepCopySnippetTest {

  @Test
  public void testDeepCopy() {
    // SETUP
    Owner alice = new Owner("Alice");
    Animal animal = new Animal("Dog", alice);

    // EXECUTE
    Animal deepCopiedAnimal = DeepCopySnippet.deepCopy(animal);

    // VERIFY
    assertNotSame(animal, deepCopiedAnimal);
    assertEquals(animal.name(), deepCopiedAnimal.name());
    assertNotSame(animal.owner(), deepCopiedAnimal.owner());
    assertEquals(animal.owner().name(), deepCopiedAnimal.owner().name());
  }

  /**
   *  Owner record.
   */
  record Owner(String name) implements Serializable {}

  /**
   * Animal record.
   */
  record Animal(String name, Owner owner) implements Serializable {}
}