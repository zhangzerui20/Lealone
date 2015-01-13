/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.lealone.test.postgresql.two_data_center;

import org.lealone.bootstrap.Lealone;
import org.lealone.cluster.config.Config.RunMode;
import org.lealone.cluster.locator.SnitchProperties;
import org.lealone.test.NodeBase;

public class PG2NodeBase extends NodeBase {
    public static void run(String rackdcPropertyFileName, Class<?> loader, String[] args) {
        System.setProperty(SnitchProperties.RACKDC_PROPERTY_FILENAME, rackdcPropertyFileName);
        init(loader, "lealone-twodc.yaml");
        Lealone.main(args);
    }

    public PG2NodeBase() {
        nodeBaseDirPrefix = "postgresql/twodc-";
        run_mode = RunMode.pg_proxy;
    }
}
