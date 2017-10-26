/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.geronimo.config.tck;

import javx.config.Config;
import javx.config.ConfigProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author <a href="mailto:struberg@apache.org">Mark Struberg</a>
 */
public class ConfigFilterTest {

    @Test
    public void testConfigFiltering() {
        Config config = ConfigProvider.getConfig();

        // unfiltered
        Assert.assertEquals(config.getValue("tck.config.test.javaconfig.configfilter.my.secret"), "SOME_SECRET");

        // filtered
        Assert.assertEquals(config.getValue("tck.config.test.javaconfig.configfilter.my.password"), "some_password");
    }

    @Test
    public void testConfigFiltering_ForLogging() {
        Config config = ConfigProvider.getConfig();

        Assert.assertEquals(
                config.filterConfigValueForLog("tck.config.test.javaconfig.configfilter.my.password",
                        config.getValue("tck.config.test.javaconfig.configfilter.my.password")), "*******");
    }
}