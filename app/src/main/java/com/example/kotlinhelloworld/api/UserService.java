package com.example.kotlinhelloworld.api;

import android.support.annotation.NonNull;

import com.example.kotlinhelloworld.model.User;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ManzarSiddique on 08-08-2017.
 */

public interface UserService {

    @GET("tracking/{version}/shipments")
    Observable<User> getUser(@NonNull @Query("search") String query);
}
