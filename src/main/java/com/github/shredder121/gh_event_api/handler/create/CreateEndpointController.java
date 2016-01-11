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
package com.github.shredder121.gh_event_api.handler.create;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.shredder121.gh_event_api.handler.AbstractEndpointController;

@RestController
@RequestMapping(method = POST, headers = "X-GitHub-Event=create")
@ConditionalOnBean(CreateHandler.class)
public class CreateEndpointController extends AbstractEndpointController<CreateHandler, CreatePayload> {

    @Autowired
    public CreateEndpointController(Collection<? extends CreateHandler> beans) {
        super(beans);
    }

    @Override
    protected Runnable runnableHandler(CreateHandler handler, CreatePayload createPayload) {
        return () -> handler.handle(createPayload);
    }
}