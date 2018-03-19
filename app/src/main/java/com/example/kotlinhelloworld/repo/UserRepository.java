package com.example.kotlinhelloworld.repo;

import com.example.kotlinhelloworld.model.User;

import java.util.List;

import rx.Observable;


/**
 * Created by ManzarSiddique on 08-08-2017.
 */

public interface UserRepository {

    Observable<List<User>> getUsers();

    Observable<User> getUser(String id);

    Observable<Void> putUsers(List<User> users);

    Observable<Void> putUser(User user);

    Observable<Void> deleteUser(User user);
}
