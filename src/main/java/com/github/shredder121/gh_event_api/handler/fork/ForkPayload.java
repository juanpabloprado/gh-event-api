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
package com.github.shredder121.gh_event_api.handler.fork;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.shredder121.gh_event_api.model.Repository;
import com.github.shredder121.gh_event_api.model.User;

/**
 * The payload passed when a {@code fork} event is received.
 *
 * @author Shredder121
 */
@lombok.Value
public class ForkPayload {

    /**
     * The target Repository.
     */
    @NotNull Repository forkee;

    /**
     * The source Repository.
     */
    @NotNull Repository repository;

    /**
     * The actor forking the Repository.
     */
    @NotNull User sender;

    @JsonCreator
    ForkPayload(
            @JsonProperty("forkee") Repository forkee,
            @JsonProperty("repository") Repository repository,
            @JsonProperty("sender") User sender) {

        this.forkee = forkee;
        this.repository = repository;
        this.sender = sender;
    }
}