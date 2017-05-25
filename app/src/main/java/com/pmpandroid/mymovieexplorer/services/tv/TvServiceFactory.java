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

import com.google.gson.Gson;
import com.pmpandroid.mymovieexplorer.BuildConfig;
import com.pmpandroid.mymovieexplorer.services.movies.MovieApi;
import com.pmpandroid.mymovieexplorer.services.movies.MovieService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rps700 on 5/24/2017.
 */

public class TvServiceFactory {

    /**
     * Gets TvService
     *
     * @param baseUrl
     * @param gson
     * @param apiKey
     * @return
     */
    public TvService get(String baseUrl, Gson gson, String apiKey) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(loggingInterceptor);
        }

        OkHttpClient httpClient = builder.build();

        TvApi TvApi = new Retrofit.Builder()
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build()
                .create(TvApi.class);

        return new TvService(TvApi, apiKey);
    }
}
