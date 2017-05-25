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
package com.pmpandroid.mymovieexplorer.services.tv;

import com.pmpandroid.mymovieexplorer.data.Category;
import com.pmpandroid.mymovieexplorer.data.ServiceResponse;
import com.pmpandroid.mymovieexplorer.services.movies.MovieApi;

import org.jetbrains.annotations.NotNull;

import rx.Observable;

/**
 * Created by rps700 on 5/24/2017.
 * TV service
 */

public class TvService {

    private final TvApi api;
    private final String apiKey;

    public TvService(TvApi api, String apiKey) {

        this.api = api;
        this.apiKey = apiKey;
    }

    public Observable<ServiceResponse> getSerials(@NotNull Category category) {
        return api.getSeries(category.key, apiKey);
    }


}
