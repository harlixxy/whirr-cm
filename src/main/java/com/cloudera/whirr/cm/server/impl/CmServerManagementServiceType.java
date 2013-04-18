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

import com.cloudera.whirr.cm.server.CmServerService;

public enum CmServerManagementServiceType {

  // Management
  MANAGEMENT(null, "MGMT"),

  // Host Monitor
  HOSTMONITOR(MANAGEMENT, "HOSTMONITOR"),

  // Service Monitor
  SERVICEMONITOR(MANAGEMENT, "SERVICEMONITOR"),

  // Activity Monitor
  ACTIVITYMONITOR(MANAGEMENT, "ACTIVITYMONITOR"),

  // Reports Manager
  REPORTSMANAGER(MANAGEMENT, "REPORTSMANAGER"),

  // Event Server
  EVENTSERVER(MANAGEMENT, "EVENTSERVER"),

  // Alerts Publisher
  ALERTPUBLISHER(MANAGEMENT, "ALERTPUBLISHER"),

  // Navigator
  NAVIGATOR(MANAGEMENT, "NAVIGATOR");

  private CmServerManagementServiceType parent;
  private String id;

  private CmServerManagementServiceType(CmServerManagementServiceType parent, String id) {
    this.parent = parent;
    this.id = id;
  }

  public CmServerManagementServiceType getParent() {
    return parent;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return MANAGEMENT.getId().toLowerCase()
        + (getParent() != null ? (CmServerService.NAME_TOKEN_DELIM + getId().toLowerCase()) : "");
  }

  public String getGroup() {
    return MANAGEMENT.getId().toLowerCase()
        + (getParent() != null ? (CmServerService.NAME_TOKEN_DELIM + getId().toLowerCase()
            + CmServerService.NAME_TOKEN_DELIM + CmServerService.NAME_QUALIFIER_GROUP)
            : (CmServerService.NAME_TOKEN_DELIM + CmServerService.NAME_QUALIFIER_GROUP));
  }
}
