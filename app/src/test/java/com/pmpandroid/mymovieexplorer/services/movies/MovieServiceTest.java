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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pmpandroid.mymovieexplorer.data.Category;
import com.pmpandroid.mymovieexplorer.data.ServiceResponse;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import rx.observers.TestSubscriber;

import static org.junit.Assert.*;

/**
 * Created by rps700 on 5/24/2017.
 */
public class MovieServiceTest {

    private MovieService movieService;
    private static final String API_KEY = "96e15158395f0b05d7d2a3c1e181dd32";
    private static final String BASE_URL = "http://api.themoviedb.org/3/";

    @Before
    public void setUp() throws Exception {

        Gson gson = new GsonBuilder().create();
        movieService = new MovieServiceFactory().get(BASE_URL, gson, API_KEY);
    }

    @Test
    public void testGetPopularMovies() throws Exception {

        //given
        TestSubscriber<ServiceResponse> testSubscriber = new TestSubscriber<>();

        //when
        movieService.getMovies(Category.POPULAR).subscribe(testSubscriber);

        //then
        testSubscriber.assertCompleted();
        testSubscriber.assertNoErrors();
        List<ServiceResponse> serviceResponses = testSubscriber.getOnNextEvents();
        assertNotNull(serviceResponses);
    }

}