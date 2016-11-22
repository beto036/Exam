package com.example.admin.w6d2exam;

import android.content.Context;

import com.example.admin.w6d2exam.model.ResultApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by admin on 11/7/2016.
 */
@Module
public class RetrofitModule {
    private Context context;


    public RetrofitModule(Context context) {
        this.context = context;
    }

    @Provides
    public Observable<ResultApi> provideUserService(){
        return RetrofitHelper.Factory.getUsers();
    }
}
