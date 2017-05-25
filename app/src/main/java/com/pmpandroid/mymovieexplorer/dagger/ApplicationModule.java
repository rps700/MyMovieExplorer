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
package com.pmpandroid.mymovieexplorer.dagger;

import android.content.Context;
import android.content.res.Resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pmpandroid.mymovieexplorer.MyMovieExplorerApplication;
import com.pmpandroid.mymovieexplorer.R;
import com.pmpandroid.mymovieexplorer.services.movies.MovieService;
import com.pmpandroid.mymovieexplorer.services.movies.MovieServiceFactory;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by rps700 on 5/23/2017.
 */
@Module
public class ApplicationModule {

    public static final String APPLICATION_CONTEXT = "applicationContext";
    public static final String BASE_URL = "baseUrl";
    private static final String API_KEY = "apiKey";

    @Singleton
    @Provides
    @Named(APPLICATION_CONTEXT)
    public Context provideApplicationContext(MyMovieExplorerApplication myMovieExplorerApplication) {
        return myMovieExplorerApplication;
    }

    @Singleton
    @Provides
    public Resources provideResources(@Named(APPLICATION_CONTEXT) Context context) {
        return context.getResources();
    }

    @Singleton
    @Provides
    public GsonBuilder provideGsonBuilder() {
        return new GsonBuilder();
    }

    @Singleton
    @Provides
    public Gson provideGson(GsonBuilder gsonBuilder) {
        return gsonBuilder.create();
    }


    @Singleton
    @Provides
    @Named(BASE_URL)
    public static String providesBaseUrl(Resources res) {
        return res.getString(R.string.base_url);
    }

    @Singleton
    @Provides
    @Named(API_KEY)
    public static String providesApiKey(Resources res) {
        return res.getString(R.string.api_key);
    }


    @Singleton
    @Provides
    public MovieService providesMovieService(@Named(BASE_URL) String baseUrl, Gson gson, @Named(API_KEY) String apiKey) {
        return new MovieServiceFactory().get(baseUrl, gson, apiKey);
    }


}
