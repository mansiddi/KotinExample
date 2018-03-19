package com.example.kotlinhelloworld.repo;

import com.example.kotlinhelloworld.model.User;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.queries.Query;

import java.util.List;

import rx.Observable;


public class StorIOUserRepository implements UserRepository {
    private final StorIOSQLite storIOSQLite;

    public StorIOUserRepository(StorIOSQLite storIOSQLite) {
//        Log.e("StorIOUserRepository","StorIOSQLite : " + storIOSQLite);
        this.storIOSQLite = storIOSQLite;
    }

    @Override
    public Observable<List<User>> getUsers() {
        return storIOSQLite.get()
                .listOfObjects(User.class)
                .withQuery(UserTableMeta.QUERY_ALL)
                .prepare()
                .asRxObservable();
    }

    @Override
    public Observable<User> getUser(String id) {
        return storIOSQLite.get()
                .object(User.class)
                .withQuery(Query.builder()
                        .table(UserTableMeta.TABLE)
                        .where(UserTableMeta.COLUMN_ID + " = ?")
                        .whereArgs(id)
                        .build())
                .prepare()
                .asRxObservable();
    }

    @Override
    public Observable<Void> putUsers(List<User> users) {
        return storIOSQLite.put()
                .objects(users)
                .prepare()
                .asRxObservable()
                .map(userPutResults -> null);
    }

    @Override
    public Observable<Void> putUser(User user) {
//        Log.e("User"," User :::: "+ new Gson().toJson(user));
        return storIOSQLite.put()
                .object(user)
                .prepare()
                .asRxObservable()
                .map(putResult -> null);
    }

    @Override
    public Observable<Void> deleteUser(User user) {
        return storIOSQLite.delete()
                .object(user)
                .prepare()
                .asRxObservable()
                .map(deleteResult -> null);
    }
}
