/**
 * Licensed to Cloudera, Inc. under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  Cloudera, Inc. licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *  
 * http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cloudera.whirr.cm.server.impl;

import com.cloudera.whirr.cm.server.CmServer;
import com.cloudera.whirr.cm.server.CmServerConstants;
import com.cloudera.whirr.cm.server.CmServerException;

public class CmServerFactory implements CmServerConstants {

  public CmServer getCmServer(String ip, String ipInternal, int port, String user, String password, CmServerLog logger)
      throws CmServerException {
    return new CmServerImpl(null, null, null, ip, ipInternal, port, user, password, logger);
  }

  public CmServer getCmServer(String version, String ip, String ipInternal, int port, String user, String password,
      CmServerLog logger) throws CmServerException {
    return new CmServerImpl(version, null, null, ip, ipInternal, port, user, password, logger);
  }

  public CmServer getCmServer(String version, String versionApi, String ip, String ipInternal, int port, String user,
      String password, CmServerLog logger) throws CmServerException {
    return new CmServerImpl(version, versionApi, null, ip, ipInternal, port, user, password, logger);
  }

  public CmServer getCmServer(String version, String versionApi, String versionCdh, String ip, String ipInternal,
      int port, String user, String password, CmServerLog logger) throws CmServerException {
    return new CmServerImpl(version, versionApi, versionCdh, ip, ipInternal, port, user, password, logger);
  }

}