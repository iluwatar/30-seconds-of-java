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

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClassLibrary {
  /**
   * Print all declared methods of the class.
   * @param cls Tested class
   * @return list of methods name
   */
  public static List<String> getAllMethods(final Class<?> cls) {
    var list = new ArrayList<String>();
    for (var method : cls.getDeclaredMethods()) {
      list.add(method.getName());
    }
    return list;
  }

  /**
   * Print all declared public field names of the class or the interface
   * the class extends.
   * @param cls Tested class
   * @return list of name of public fields
   */
  public static List<String> getAllFieldNames(final Class<?> cls) {
    return Arrays.stream(cls.getFields())
            .map(Field::getName)
            .collect(Collectors.toList());
  }

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
