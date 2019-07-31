package com.takehome.opentabletakehome.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by nivesuresh on 7/27/19.
 */

public class NewsApplication extends Application {

    AppComponent appComponent;

    public static NewsApplication get(Context context) {
        return (NewsApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
