/*
 * Copyright 2019 The JimDB Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package io.jimdb.test.utils.lang;

import io.jimdb.common.utils.lang.MathUtil;

import org.junit.Assert;
import org.junit.Test;

/**
 * @version V1.0
 */
public class MathUtilTest {
  @Test
  public void powerTwoTest() {
    for (int i = 1; i < 1000; i++) {
      Assert.assertEquals(getResult(i), MathUtil.powerTwo(i));
    }
  }

  private int getResult(int num) {
    return getValueByPower(getPowerOfTwo(num));
  }

  private int getPowerOfTwo(int num) {
    if (num == 1) {
      return 1;
    }
    int power = 0;
    int temp = num;
    while (temp > 0) {
      temp = temp >> 1;
      power++;
    }
    if (num == getValueByPower(power - 1)) {
      power = power - 1;
    }
    return power;
  }

  private int getValueByPower(int power) {
    return 1 << power;
  }
}
