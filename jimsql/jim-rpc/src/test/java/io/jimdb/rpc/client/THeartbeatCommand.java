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
package io.jimdb.rpc.client;

import io.jimdb.rpc.client.command.Command;
import io.jimdb.rpc.client.heartbeat.HeartbeatCommand;

/**
 * @version V1.0
 */
public class THeartbeatCommand implements HeartbeatCommand {
  TBaseCommand request;

  public THeartbeatCommand() {
    request = new TBaseCommand();
  }

  public THeartbeatCommand(TBaseCommand request) {
    this.request = request;
  }

  @Override
  public Command build() {
    return request;
  }

  @Override
  public boolean verify(Command ping, Command pong) {
    return false;
  }
}
