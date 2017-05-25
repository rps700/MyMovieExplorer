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
package com.pmpandroid.mymovieexplorer;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.pmpandroid.mymovieexplorer.dagger.ApplicationComponent;
import com.pmpandroid.mymovieexplorer.dagger.DaggerApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * Created by rps700 on 5/23/2017.
 */

public class MyMovieExplorerApplication extends DaggerApplication {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    ApplicationComponent component;


    @Override
    public void onCreate() {
        super.onCreate();

        //dagger setup
        setUpAppComponent();

    }

    private void setUpAppComponent() {
        if (component == null) {
            component = (ApplicationComponent) applicationInjector();
        }
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        //Ensure we're chaching the component here since this is called from higher up in the class hierarchy
        if (component == null) {
            component = (ApplicationComponent) DaggerApplicationComponent.builder().create(this);
        }
        return component;
    }
}
