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
package com.github.shredder121.gh_event_api.testutil;

import java.time.*;

public class DateTimeHelpers {

    private DateTimeHelpers() {
    }

    public static ZonedDateTime dt(String date, String time) {
        return ZonedDateTime.of(d(date), t(time), ZoneId.ofOffset("GMT", ZoneOffset.UTC));
    }

    public static LocalDate d(String date) {
        return LocalDate.parse(date);
    }

    public static LocalTime t(String time) {
        return LocalTime.parse(time);
    }
}