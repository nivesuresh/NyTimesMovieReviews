package com.takehome.opentabletakehome.base;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nivesuresh on 7/27/19.
 */

@Module
public class AppModule {
    private final NewsApplication application;

    public AppModule(NewsApplication app) {
        this.application = app;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

}
