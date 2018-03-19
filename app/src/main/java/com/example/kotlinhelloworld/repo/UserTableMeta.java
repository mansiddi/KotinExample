package com.example.kotlinhelloworld.repo;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.kotlinhelloworld.model.Address;
import com.example.kotlinhelloworld.model.User;
import com.google.gson.Gson;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.operations.delete.DefaultDeleteResolver;
import com.pushtorefresh.storio.sqlite.operations.delete.DeleteResolver;
import com.pushtorefresh.storio.sqlite.operations.delete.DeleteResult;
import com.pushtorefresh.storio.sqlite.operations.get.DefaultGetResolver;
import com.pushtorefresh.storio.sqlite.operations.get.GetResolver;
import com.pushtorefresh.storio.sqlite.operations.put.DefaultPutResolver;
import com.pushtorefresh.storio.sqlite.operations.put.PutResolver;
import com.pushtorefresh.storio.sqlite.operations.put.PutResult;
import com.pushtorefresh.storio.sqlite.queries.DeleteQuery;
import com.pushtorefresh.storio.sqlite.queries.InsertQuery;
import com.pushtorefresh.storio.sqlite.queries.Query;
import com.pushtorefresh.storio.sqlite.queries.RawQuery;
import com.pushtorefresh.storio.sqlite.queries.UpdateQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ManzarSiddique on 08-08-2017.
 */

public class UserTableMeta {
    public static final String TABLE = "user";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_FIRST_NAME = "first_name";
    public static final String COLUMN_LAST_NAME = "last_name";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_IS_MARRIED = "is_married";
//    public static final String COLUMN_DOB = "dob";

    public static final PutResolver<User> PUT_RESOLVER = new DefaultPutResolver<User>() {

        @NonNull
        @Override
        protected InsertQuery mapToInsertQuery(@NonNull User object) {
            Log.e("InsertQuery",""+ new Gson().toJson(object));
            return InsertQuery.builder()
                    .table(TABLE)
                    .build();
        }

        @NonNull
        @Override
        protected UpdateQuery mapToUpdateQuery(@NonNull User object) {
            Log.e("UpdateQuery",""+ new Gson().toJson(object));
            return UpdateQuery.builder()
                    .table(TABLE)
                    .where(COLUMN_ID + " = ?")
                    .whereArgs(object.id())
                    .build();
        }

        @NonNull
        @Override
        protected ContentValues mapToContentValues(@NonNull User object) {
            final ContentValues values = new ContentValues(5);

            values.put(COLUMN_ID, object.id());
            values.put(COLUMN_FIRST_NAME, object.firstName());
            values.put(COLUMN_LAST_NAME, object.lastName());
            values.put(COLUMN_GENDER, object.gender());
            values.put(COLUMN_IS_MARRIED, object.isMarried() ? 1 : 0);

            Log.e("mapToContentValues",""+ new Gson().toJson(values));
            return values;
        }

        @NonNull
        @Override
        public PutResult performPut(@NonNull StorIOSQLite storIOSQLite, @NonNull User object) {
            storIOSQLite
                    .delete()
                    .byQuery(DeleteQuery.builder()
                            .table(AddressTableMeta.TABLE)
                            .where(AddressTableMeta.COLUMN_ID + " = ?")
                            .whereArgs(object.id())
                            .build()
                    ).prepare()
                    .executeAsBlocking();

            List<Address> addressList = new ArrayList<>(object.address().size());
            for (Address address : object.address()) {
                addressList.add(address.toBuilder()
                        .id(object.id())
                        .build());
            }

            storIOSQLite
                    .put()
                    .objects(addressList)
                    .prepare()
                    .executeAsBlocking();

            return super.performPut(storIOSQLite, object);
        }
    };

    public static final GetResolver<User> GET_RESOLVER = new DefaultGetResolver<User>() {
        @NonNull
        private final ThreadLocal<StorIOSQLite> storIOSQLiteFromPerformGet = new ThreadLocal<>();

        @NonNull
        @Override
        public User mapFromCursor(@NonNull Cursor cursor) {
            final StorIOSQLite storIOSQLite = storIOSQLiteFromPerformGet.get();

            final String id = cursor.getString(cursor.getColumnIndex(COLUMN_ID));

            final List<Address> addressList = storIOSQLite
                    .get()
                    .listOfObjects(Address.class)
                    .withQuery(Query.builder()
                            .table(AddressTableMeta.TABLE)
                            .where(AddressTableMeta.COLUMN_ID + " = ?")
                            .whereArgs(id)
                            .build())
                    .prepare()
                    .executeAsBlocking();

            return User.builder()
                    .id(cursor.getString(cursor.getColumnIndex(COLUMN_ID)))
                    .address(addressList)
                    .firstName(cursor.getString(cursor.getColumnIndex(COLUMN_FIRST_NAME)))
                    .lastName(cursor.getString(cursor.getColumnIndex(COLUMN_LAST_NAME)))
                    .gender(cursor.getString(cursor.getColumnIndex(COLUMN_GENDER)))
                    .isMarried(cursor.getInt(cursor.getColumnIndex(COLUMN_IS_MARRIED))==1)  //0 or 1
//                    .dob(new Date(cursor.getString(cursor.getColumnIndex(COLUMN_DOB))))
                    .build();
        }

        @NonNull
        @Override
        public Cursor performGet(@NonNull StorIOSQLite storIOSQLite, @NonNull RawQuery rawQuery) {
            storIOSQLiteFromPerformGet.set(storIOSQLite);
            return super.performGet(storIOSQLite, rawQuery);
        }

        @NonNull
        @Override
        public Cursor performGet(@NonNull StorIOSQLite storIOSQLite, @NonNull Query query) {
            storIOSQLiteFromPerformGet.set(storIOSQLite);
            return super.performGet(storIOSQLite, query);
        }

    };

    public static final DeleteResolver<User> DELETE_RESOLVER = new DefaultDeleteResolver<User>() {

        @NonNull
        @Override
        protected DeleteQuery mapToDeleteQuery(@NonNull User object) {
            return DeleteQuery.builder()
                    .table(TABLE)
                    .where(COLUMN_ID + " = ?")
                    .whereArgs(object.id())
                    .build();
        }

        @NonNull
        @Override
        public DeleteResult performDelete(@NonNull StorIOSQLite storIOSQLite, @NonNull User object) {
            storIOSQLite
                    .delete()
                    .byQuery(DeleteQuery.builder()
                            .table(AddressTableMeta.TABLE)
                            .where(AddressTableMeta.COLUMN_ID + " = ?")
                            .whereArgs(object.id())
                            .build()
                    ).prepare()
                    .executeAsBlocking();

            return super.performDelete(storIOSQLite, object);
        }
    };

    public static final Query QUERY_ALL = Query.builder()
            .table(TABLE)
            .build();
}
