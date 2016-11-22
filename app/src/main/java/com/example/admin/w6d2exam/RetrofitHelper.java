package com.example.admin.w6d2exam;

import com.example.admin.w6d2exam.model.ResultApi;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by admin on 11/6/16.
 */

public class RetrofitHelper {

    public static final String BASE_URL = "https://randomuser.me/";

    public static class Factory {
        private static final String TAG = "RetrofitHelperTAG_";

        public static Retrofit create() {
            return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .build();
        }

        public static Observable<ResultApi> getUsers() {
            Retrofit retrofit = create();
            UserService userService = retrofit.create(UserService.class);
            return userService.getUser();
        }

    }

}
