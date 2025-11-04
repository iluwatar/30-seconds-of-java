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

package algorithm;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.jupiter.api.Test;

/**
 * Tests for the {@link TokenBucketRateLimiterSnippet} class.
 */

public class TokenBucketRateLimiterSnippetTest {

  /**
  * Test for {@link TokenBucketRateLimiterSnippet#isOperationAllowed()}.
  * Method to test rate limit only for success /or operation allowed (true) cases in 1sec
  */
  @Test
  void test1_isOperationAllowed() throws InterruptedException, ExecutionException {
    TokenBucketRateLimiterSnippet limiterSnippet = new TokenBucketRateLimiterSnippet(10);
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    List<Callable<Boolean>> tasks = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
      tasks.add(limiterSnippet::isOperationAllowed);
    }
    List<Future<Boolean>> futureList = executorService.invokeAll(tasks);
    executorService.shutdown();

    int successCount = 0;
    int throttleCount = 0;
    for (Future<Boolean> future : futureList) {
      if (future.get()) {
        successCount++;
      } else {
        throttleCount++;
      }
    }

    assertTrue(successCount == 10 && throttleCount == 0);
  }

  /**
  * Test for {@link TokenBucketRateLimiterSnippet#isOperationAllowed()}.
  * Method to test rate limit for success (true) AND throttled (false) cases in 1sec
  */
  @Test
  void test2_isOperationAllowed() throws InterruptedException, ExecutionException {
    TokenBucketRateLimiterSnippet limiterSnippet = new TokenBucketRateLimiterSnippet(10);
    ExecutorService executorService = Executors.newFixedThreadPool(12);
    List<Callable<Boolean>> tasks = new ArrayList<>();
    for (int i = 1; i <= 12; i++) {
      tasks.add(limiterSnippet::isOperationAllowed);
    }
    List<Future<Boolean>> futureList = executorService.invokeAll(tasks);
    executorService.shutdown();

    int successCount = 0;
    int throttleCount = 0;
    for (Future<Boolean> future : futureList) {
      if (future.get()) {
        successCount++;
      } else {
        throttleCount++;
      }
    }

    assertTrue(successCount == 10 && throttleCount == 2);
  }

}
