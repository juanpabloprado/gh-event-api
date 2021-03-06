/*
 * Copyright 2017 Shredder121.
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

import com.fasterxml.jackson.databind.PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.shredder121.gh_event_api.model.Organization;
import com.github.shredder121.gh_event_api.model.Repository;
import com.github.shredder121.gh_event_api.model.User;
import com.github.shredder121.gh_event_api.model.json.PropertyBasedJsonCreator;

/**
 * The payload passed when a {@code fork} event is received.
 *
 * @author Shredder121
 * @see <a href="https://developer.github.com/v3/activity/events/types/#forkevent">The fork event on GitHub</a>
 */
@lombok.Value
@JsonNaming(LowerCaseWithUnderscoresStrategy.class)
@lombok.RequiredArgsConstructor(
        access = lombok.AccessLevel.MODULE,
        onConstructor = @__(@PropertyBasedJsonCreator)
)
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
     * The organization the repository belongs to.
     * Only non-null with organization webhooks.
     */
    Organization organization;

    /**
     * The actor forking the Repository.
     */
    @NotNull User sender;
}
