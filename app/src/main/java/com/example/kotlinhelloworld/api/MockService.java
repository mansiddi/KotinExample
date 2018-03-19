package com.example.kotlinhelloworld.api;

import android.support.annotation.NonNull;

import com.example.kotlinhelloworld.data.MockUser;
import com.example.kotlinhelloworld.model.User;

import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ManzarSiddique on 08-08-2017.
 */

public class MockService implements UserService {
    @Override
    public Observable<User> getUser(@NonNull @Query("search") String query) {
        if (query.equals(MockUser.ONE)) {
            return Observable.just(MockUser.ONE);
        } else {
            return Observable.just(MockUser.TWO);
        }
    }
}
