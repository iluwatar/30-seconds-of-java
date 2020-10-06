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

/*
 * 30 Seconds of Java code library
 *
 */
public class HaversineFormulaSnippet {

  // Radius of sphere on which the points are, in this case Earth.
  private static final double SPHERE_RADIUS_IN_KM = 6372.8;

  /**
   * Haversine formula for calculating distance between two latitude, longitude points.
   *
   * @param latA Latitude of point A
   * @param longA Longitude of point A
   * @param latB Latitude of point B
   * @param longB Longitude of point B
   * @return the distance between the two points.
   */
  public static double findHaversineDistance(double latA, double longA, double latB, double longB) {
    if (!isValidLatitude(latA)
        || !isValidLatitude(latB)
        || !isValidLongitude(longA)
        || !isValidLongitude(longB)) {
      throw new IllegalArgumentException();
    }

    // Calculate the latitude and longitude differences
    var latitudeDiff = Math.toRadians(latB - latA);
    var longitudeDiff = Math.toRadians(longB - longA);

    var latitudeA = Math.toRadians(latA);
    var latitudeB = Math.toRadians(latB);

    // Calculating the distance as per haversine formula
    var a = Math.pow(Math.sin(latitudeDiff / 2), 2)
            + Math.pow(Math.sin(longitudeDiff / 2), 2) * Math.cos(latitudeA) * Math.cos(latitudeB);
    var c = 2 * Math.asin(Math.sqrt(a));
    return SPHERE_RADIUS_IN_KM * c;
  }

  // Check for valid latitude value
  private static boolean isValidLatitude(double latitude) {
    return latitude >= -90 && latitude <= 90;
  }

  // Check for valid longitude value
  private static boolean isValidLongitude(double longitude) {
    return longitude >= -180 && longitude <= 180;
  }
}
