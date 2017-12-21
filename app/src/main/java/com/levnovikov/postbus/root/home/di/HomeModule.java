package com.levnovikov.postbus.root.home.di;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;

import com.levnovikov.postbus.R;
import com.levnovikov.postbus.root.home.HomeView;
import com.levnovikov.postbus.root.home.prebooking.PrebookingBuilder;
import com.levnovikov.stream_state.AppState;
import com.levnovikov.stream_state.AppStateStreamProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;

/**
 * Author: lev.novikov
 * Date: 14/12/17.
 */

@Module
public class HomeModule {

    private Activity activity;

    public HomeModule(Activity activity) {
        this.activity = activity;
    }

    @HomeScope
    @Provides
    Context provideContext() {
        return activity;
    }

    @HomeScope
    @Provides
    PrebookingBuilder providePrebookingBuilder(HomeComponent component) {
        return new PrebookingBuilder(component);
    }

    @HomeScope
    @Provides
    HomeView provideView(LayoutInflater inflater) {
        return (HomeView) inflater.inflate(R.layout.home_view, null, true);
    }

    @HomeScope
    @Provides
    Observable<AppState> provideAppStateStream(AppStateStreamProvider provider) {
        return provider.provideAppStateStream();
    }

    @HomeScope
    @Provides
    LayoutInflater provideInflater() {
        return activity.getLayoutInflater();
    }
}
