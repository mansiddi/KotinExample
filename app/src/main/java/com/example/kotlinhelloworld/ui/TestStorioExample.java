package com.example.kotlinhelloworld.ui;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.kotlinhelloworld.R;
import com.example.kotlinhelloworld.model.Address;
import com.example.kotlinhelloworld.model.User;
import com.example.kotlinhelloworld.repo.AddressTableMeta;
import com.example.kotlinhelloworld.repo.DbOpenHelper;
import com.example.kotlinhelloworld.repo.StorIOUserRepository;
import com.example.kotlinhelloworld.repo.UserTableMeta;
import com.google.gson.Gson;
import com.pushtorefresh.storio.sqlite.SQLiteTypeMapping;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.impl.DefaultStorIOSQLite;

import java.util.List;

import rx.Observable;

public class TestStorioExample extends AppCompatActivity {
    StorIOUserRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_storio_ahmed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DbOpenHelper sqLiteOpenHelper = new DbOpenHelper(TestStorioExample.this);
        sqLiteOpenHelper.getWritableDatabase();
        StorIOSQLite storIOSQLite = getStorioInstance(sqLiteOpenHelper);
        repository = new StorIOUserRepository(storIOSQLite);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//        MockService mockService = new MockService();
//        mockService.getUser("1001");
//        Log.e("TAG", " GET USER : "+ new Gson().toJson(mockService.getUser("1001")));

       User user = User.builder()
                .id("1001")
                .addAddress(Address.builder()
                        .id("1001")
                        .houseNo(100)
                        .street("x-b-/12 ABC")
                        .city("Kolkata")
                        .state("W.B")
                        .build())
                .addAddress(Address.builder()
                        .id("1001")
                        .houseNo(101)
                        .street("x-b-/13 ABC")
                        .city("Kolkata")
                        .state("W.B")
                        .build())
                .firstName("Manzar")
                .lastName("Siddique")
                .gender("Male")
                .isMarried(true)
//                .dob(new Date("1988-15-03T12:34:14.000"))
                .build();

        repository.putUser(user);

//        Log.e(" putUser ","repository.putUser(user) :: "+repository.putUser(user));

//        Log.e("PUT DATA",""+new Gson().toJson(user));
//        Log.e("onSubscribe",""+new Gson().toJson(repository.getUsers()));

//        test();
//        Log.e("GET DATA",""+new Gson().toJson(repository.getUsers().map(usr -> { return usr;})));
//        repository.getUser();
    }

    private Observable<List<User>> test(){
        repository.getUsers()
                .flatMap(users -> {Log.e("users: " , " :::: "+ new Gson().toJson(users));
        return Observable.from(users);});

        return null;
    }


    private StorIOSQLite getStorioInstance(SQLiteOpenHelper sqLiteOpenHelper){
        return DefaultStorIOSQLite.builder()
                .sqliteOpenHelper(sqLiteOpenHelper)
                .addTypeMapping(User.class, SQLiteTypeMapping.<User>builder()
                        .putResolver(UserTableMeta.PUT_RESOLVER)
                        .getResolver(UserTableMeta.GET_RESOLVER)
                        .deleteResolver(UserTableMeta.DELETE_RESOLVER)
                        .build())
                .addTypeMapping(Address.class, SQLiteTypeMapping.<Address>builder()
                        .putResolver(AddressTableMeta.PUT_RESOLVER)
                        .getResolver(AddressTableMeta.GET_RESOLVER)
                        .deleteResolver(AddressTableMeta.DELETE_RESOLVER)
                        .build())
                .build();
    }
}
