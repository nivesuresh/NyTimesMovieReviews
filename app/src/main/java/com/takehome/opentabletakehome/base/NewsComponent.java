package com.takehome.opentabletakehome.base;

import com.takehome.opentabletakehome.mvp.NewsActivity;
import com.takehome.opentabletakehome.mvp.NewsPresenter;

import dagger.Component;

/**
 * Created by nivesuresh on 7/27/19.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = NewsModule.class)
public interface NewsComponent {
    void inject(NewsActivity activity);

    IPresenter getMainPresenter();
}
