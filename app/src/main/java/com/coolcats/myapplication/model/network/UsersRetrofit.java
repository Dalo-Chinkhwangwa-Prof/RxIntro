package com.coolcats.myapplication.model.network;

import android.util.Log;

import com.coolcats.myapplication.model.UsersResponse;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.coolcats.myapplication.util.Constants.BASE_URL;
import static com.coolcats.myapplication.util.Constants.END_POINT;
import static com.coolcats.myapplication.util.Constants.RESULTS_QUERY;

public class UsersRetrofit {

    private UserService userService = createRetrofit().create(UserService.class);

    private Retrofit createRetrofit() {
        return new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public Single<UsersResponse> getRandomUsers(int count){
        Log.d("TAG_X", "getRandomUsers onThread -> "+Thread.currentThread().getId());
        return userService.getAllUsers(count);
    }

    interface UserService{
        @GET(END_POINT)
        public Single<UsersResponse> getAllUsers(@Query(RESULTS_QUERY) int results);
    }


}
