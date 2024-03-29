package com.takehome.opentabletakehome.base;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by nivesuresh on 7/27/19.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(NewsApplication application);
}
