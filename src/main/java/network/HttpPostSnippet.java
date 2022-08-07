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

package network;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.StringJoiner;

/*
 * 30 Seconds of Java code library
 *
 */
public class HttpPostSnippet {
  /**
   * Performs HTTP POST request. Credits https://stackoverflow.com/questions/3324717/sending-http-post-request-in-java
   *
   * @param address   the URL of the connection in String format, like "http://www.google.com"
   * @param arguments the body of the POST request, as a HashMap
   * @return response object
   * @throws IOException          if an I/O error occurs
   * @throws InterruptedException if the operation is interrupted
   */
  public static HttpResponse<String> httpPost(String address, HashMap<String, String> arguments)
          throws IOException, InterruptedException {
    var sj = new StringJoiner("&");
    for (var entry : arguments.entrySet()) {
      sj.add(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8) + "="
              + URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
    }

    var out = sj.toString().getBytes(StandardCharsets.UTF_8);
    var request = HttpRequest.newBuilder()
            .uri(URI.create(address))
            .headers("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
            .POST(HttpRequest.BodyPublishers.ofByteArray(out))
            .build();

    return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
  }
}
