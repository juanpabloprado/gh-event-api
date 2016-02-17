/*
 * Copyright 2016 Shredder121.
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
package com.github.shredder121.gh_event_api.handler.deployment_status;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.shredder121.gh_event_api.handler.AbstractEndpointController;

/**
 * Endpoint controller for {@code deployment_status} events.
 *
 * This controller is bound to {@link DeploymentStatusHandler}
 * and will only be enabled when there are any on the component scan path.
 *
 * @author Shredder121
 */
@RestController
@RequestMapping(headers = "X-GitHub-Event=deployment_status")
@ConditionalOnBean(DeploymentStatusHandler.class)
class DeploymentStatusEndpointController extends AbstractEndpointController<DeploymentStatusHandler, DeploymentStatusPayload> {

    @Autowired
    DeploymentStatusEndpointController(Collection<? extends DeploymentStatusHandler> beans) {
        super(beans);
    }

    @Override
    protected Runnable runnableHandler(DeploymentStatusHandler handler, DeploymentStatusPayload payload) {
        return () -> handler.handle(payload);
    }
}