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

import java.util.List;

/**
 * Created by rps700 on 5/24/2017.
 * Represents service response from https://developers.themoviedb.org/3
 */

public class ServiceResponse {

    int page;
    List<Result> results;
    int total_results;
    int total_pages;
}
