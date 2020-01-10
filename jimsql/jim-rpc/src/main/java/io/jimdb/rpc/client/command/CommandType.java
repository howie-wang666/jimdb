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
package io.jimdb.rpc.client.command;

/**
 * Command type.
 */
public enum CommandType {
  REQUEST(0), RESPONSE(1);

  private int value;

  CommandType(int value) {
    this.value = value;
  }

  public static CommandType valueOf(final int value) {
    switch (value) {
      case 0:
        return REQUEST;
      default:
        return RESPONSE;
    }
  }

  public int getValue() {
    return value;
  }
}
