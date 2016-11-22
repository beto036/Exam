package com.example.admin.w6d2exam;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by admin on 11/7/2016.
 */
@Singleton
@Component(modules = {RetrofitModule.class})
public interface RetrofitComponent {
    void inject(MainActivity mainActivity);
}
