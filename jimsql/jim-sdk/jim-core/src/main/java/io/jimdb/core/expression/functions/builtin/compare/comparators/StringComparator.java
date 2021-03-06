/*
 * Copyright 2019 The JIMDB Authors.
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
package io.jimdb.core.expression.functions.builtin.compare.comparators;

import io.jimdb.core.Session;
import io.jimdb.core.expression.Expression;
import io.jimdb.core.expression.ValueAccessor;
import io.jimdb.core.values.LongValue;
import io.jimdb.core.values.Value;

/**
 * @version V1.0
 */
final class StringComparator extends ExprComparator {
  static final StringComparator INSTANCE = new StringComparator();

  private StringComparator() {
  }

  @Override
  public LongValue compare(Session session, Expression expr1, ValueAccessor row1, Expression expr2, ValueAccessor row2, boolean nullComp) {
    Value v1 = expr1.execString(session, row1);
    Value v2 = expr2.execString(session, row2);

    if (v1 == null || v2 == null) {
      return nullComp ? compareNull(v1, v2) : null;
    }
    return LongValue.getInstance(v1.compareTo(session, v2));
  }
}
