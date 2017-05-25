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
package com.pmpandroid.mymovieexplorer.services.movies;

import com.pmpandroid.mymovieexplorer.data.ServiceResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by rps700 on 5/23/2017.
 * Movie APi
 */

public interface MovieApi {

    @GET("movie/{category}")
    Observable<ServiceResponse> getMovies(@Path("category") final String category, @Query("api_key") final String apiKey);
}
