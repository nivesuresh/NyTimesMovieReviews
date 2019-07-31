package com.takehome.opentabletakehome.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by nivesuresh on 7/27/19.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupComponent((AppComponent) NewsApplication.get(this).getAppComponent());
    }

    protected abstract void setupComponent(AppComponent appComponent);
}
