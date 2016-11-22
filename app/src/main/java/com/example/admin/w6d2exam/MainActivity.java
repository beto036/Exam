package com.example.admin.w6d2exam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.admin.w6d2exam.model.Result;
import com.example.admin.w6d2exam.model.ResultApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MAinActivityTAG_";
    public final String json = "{\"results\":[{\"gender\":\"female\",\"name\":{\"title\":\"mrs\",\"first\":\"laura\",\"last\":\"prieto\"},\"location\":{\"street\":\"4215 calle de ángel garcía\",\"city\":\"móstoles\",\"state\":\"comunidad de madrid\",\"postcode\":38148},\"email\":\"laura.prieto@example.com\",\"login\":{\"username\":\"orangegorilla186\",\"password\":\"father\",\"salt\":\"V21ZXEXi\",\"md5\":\"16fd0fcfdf8394d34f78eac8d937ea0d\",\"sha1\":\"8ff0cacf4eb64034abfc7aaef693a1caf4d4e16a\",\"sha256\":\"79df9ca6cf23d1884e2fc75ab89044b8a6146fbf90369403c901b78a60d5ee5c\"},\"dob\":\"1961-09-11 20:56:33\",\"registered\":\"2012-06-06 23:33:46\",\"phone\":\"915-925-889\",\"cell\":\"637-679-236\",\"id\":{\"name\":\"DNI\",\"value\":\"67715235-M\"},\"picture\":{\"large\":\"https://randomuser.me/api/portraits/women/50.jpg\",\"medium\":\"https://randomuser.me/api/portraits/med/women/50.jpg\",\"thumbnail\":\"https://randomuser.me/api/portraits/thumb/women/50.jpg\"},\"nat\":\"ES\"}],\"info\":{\"seed\":\"064354194cc5be6b\",\"results\":1,\"page\":1,\"version\":\"1.1\"}}";
    private OkHttpClient client;

    private static final String url = "https://randomuser.me/api";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        client = new OkHttpClient();
//
//
//            run(url);

        Observable<ResultApi> observable = RetrofitHelper.Factory.getUsers();

        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultApi>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.toString());
                    }

                    @Override
                    public void onNext(ResultApi resultApi) {
                        for (Result result : resultApi.getResults())
                            Log.d(TAG, "onCreate: " + result.toString());
                    }
                });


    }

    void run(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new GsonBuilder().create();
                ResultApi resultApi = gson.fromJson(response.body().string(), ResultApi.class);

                for (Result result : resultApi.getResults())
                    Log.d(TAG, "onCreate: " + result.toString());
            }
        });
    }
}
