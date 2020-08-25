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

package cls;

import java.lang.reflect.InvocationTargetException;

/*
 * 30 Seconds of Java code library
 *
 */
public class CreatingObjectSnippet {
  /**
   * Create object using reflection.
   *
   * @param cls fully qualified name of class includes the package name as String
   * @return object
   * @throws NoSuchMethodException if a method that does not exist at runtime.
   * @throws IllegalAccessException <p>if an currently executing method
   * does not have access to the definition of the specified class, field, method or constructor</p>
   * @throws InvocationTargetException <p>InvocationTargetException is a checked exception
   * that wraps an exception thrown by an invoked method or constructor.</p>
   * @throws InstantiationException <p>when an method tries to create an instance of a class
   * using the newInstance method in class Class.</p>
   * @throws ClassNotFoundException <p>when an application tries to load in a class
   * through its string name.</p>
   */
  public static Object createObject(String cls)
          throws NoSuchMethodException,
          IllegalAccessException,
          InvocationTargetException,
          InstantiationException,
          ClassNotFoundException {
    var objectClass = Class.forName(cls);
    var objectConstructor = objectClass.getConstructor();
    return objectConstructor.newInstance();
  }
}
