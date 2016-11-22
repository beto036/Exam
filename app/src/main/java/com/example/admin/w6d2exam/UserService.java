package com.example.admin.w6d2exam;

import com.example.admin.w6d2exam.model.ResultApi;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by admin on 11/20/2016.
 */
public interface UserService {

    @GET("api")
    Observable<ResultApi> getUser();

}
