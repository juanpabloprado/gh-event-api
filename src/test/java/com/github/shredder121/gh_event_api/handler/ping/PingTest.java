/*
 * Copyright 2015 Shredder121.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.shredder121.gh_event_api.handler.ping;

import org.springframework.boot.test.SpringApplicationConfiguration;

import com.github.shredder121.gh_event_api.GHEventApiServer;
import com.github.shredder121.gh_event_api.handler.AbstractHandlerTest;

@SpringApplicationConfiguration(classes = {GHEventApiServer.class})
public class PingTest extends AbstractHandlerTest {

    public PingTest() {
        super("ping", "ef61d462314dfd950ad5a6e15798bb5432de4e07");
    }

    @Override
    public void awaitCompletion() throws InterruptedException {
        Thread.sleep(500);
    }
}