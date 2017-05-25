/*
 * Copyright (C) 2017 PMP Creative Studioz
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
**/
package com.pmpandroid.mymovieexplorer.data;

/**
 * Created by rps700 on 5/24/2017.
 */

public enum Category {
    NOW_PLAYING("now_playing", "NOW PLAYING"),
    POPULAR,
    TOP_RATED("top_rated", "TOP RATED"),
    UPCOMING;

    public final String key;
    public final String displayName;

    Category() {
        this.key = this.name().toLowerCase();
        this.displayName = this.name();
    }

    Category(String key, String displayName) {
        this.key = key;
        this.displayName = displayName;
    }

}
