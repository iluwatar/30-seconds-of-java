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

/**
 * TokenBucketRateLimiterSnippet.
 */

public class TokenBucketRateLimiterSnippet {
  private final int limit;
  private int capacity;
  private long lastRefillTime;

  /**
  * Public constructor to instantiate the limit.
  *
  * @param limit of the bucket, defining the number of operations (e.g. 10) allowed per second
  */
  public TokenBucketRateLimiterSnippet(int limit) {
    this.limit = limit;
    this.capacity = limit;
    this.lastRefillTime = System.currentTimeMillis();
  }

  /**
  * A token bucket rate limiter algorithm
  * to check operation is allowed or not with in the 1sec period.
  *
  * @return {@code true} if operation is allowed, otherwise {code false} for throttling
  */
  public boolean isOperationAllowed() {
    refill();
    if (capacity > 0) {
      capacity--;
      return true;
    }
    return false;
  }

  /**
  * To refill the capacity in every 1sec or 1000ms.
  */
  private void refill() {
    if (System.currentTimeMillis() - lastRefillTime >= 1000) {
      capacity = limit;
      lastRefillTime = System.currentTimeMillis();
    }
  }

}

