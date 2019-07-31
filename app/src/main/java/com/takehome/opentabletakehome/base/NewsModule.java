package com.takehome.opentabletakehome.base;

import android.content.Context;

import com.takehome.opentabletakehome.mvp.NewsPresenter;
import com.takehome.opentabletakehome.mvp.NewsView;
import com.takehome.opentabletakehome.service.NyTimesService;
import com.takehome.opentabletakehome.service.RetrofitClientInstance;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nivesuresh on 7/27/19.
 */

@Module
public class NewsModule {
    private NewsView view;
    private Context context;

    public NewsModule(NewsView view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    public NewsView provideView() {
        return view;
    }

    @Provides
    public NyTimesService provideService() {
        return RetrofitClientInstance.getRetrofitInstance(context).create(NyTimesService.class);
    }

    @Provides
    public IPresenter providePresenter(Context context, NewsView newsView, NyTimesService service) {
        return new NewsPresenter(context, newsView, service);
    }

}
