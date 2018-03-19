package com.example.kotlinhelloworld.repo;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;

import com.example.kotlinhelloworld.model.Address;
import com.pushtorefresh.storio.sqlite.operations.delete.DefaultDeleteResolver;
import com.pushtorefresh.storio.sqlite.operations.delete.DeleteResolver;
import com.pushtorefresh.storio.sqlite.operations.get.DefaultGetResolver;
import com.pushtorefresh.storio.sqlite.operations.get.GetResolver;
import com.pushtorefresh.storio.sqlite.operations.put.DefaultPutResolver;
import com.pushtorefresh.storio.sqlite.operations.put.PutResolver;
import com.pushtorefresh.storio.sqlite.queries.DeleteQuery;
import com.pushtorefresh.storio.sqlite.queries.InsertQuery;
import com.pushtorefresh.storio.sqlite.queries.UpdateQuery;

/**
 * Created by ManzarSiddique on 08-08-2017.
 */

public class AddressTableMeta {

    public static final String TABLE = "address";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_HOUSE_NO = "house_no";
    public static final String COLUMN_STREET = "street";
    public static final String COLUMN_CITY = "city";
    public static final String COLUMN_STATE = "state";

    public static final PutResolver<Address> PUT_RESOLVER = new DefaultPutResolver<Address>() {

        @NonNull
        @Override
        protected InsertQuery mapToInsertQuery(@NonNull Address object) {
            return InsertQuery.builder()
                    .table(TABLE)
                    .build();
        }

        @NonNull
        @Override
        protected UpdateQuery mapToUpdateQuery(@NonNull Address object) {
            return UpdateQuery.builder()
                    .table(TABLE)
                    .where(COLUMN_ID + " = ?")
                    .whereArgs(object.id())
                    .build();
        }

        @NonNull
        @Override
        protected ContentValues mapToContentValues(@NonNull Address object) {
            final ContentValues values = new ContentValues(5);

            values.put(COLUMN_ID, object.id());
            values.put(COLUMN_HOUSE_NO, object.houseNo());
            values.put(COLUMN_STATE, object.state());
            values.put(COLUMN_STREET, object.street());
            values.put(COLUMN_CITY, object.city());

            return values;
        }
    };

    public static final GetResolver<Address> GET_RESOLVER = new DefaultGetResolver<Address>() {

        @NonNull
        @Override
        public Address mapFromCursor(@NonNull Cursor cursor) {
            return Address.builder()
                    .id(cursor.getString(cursor.getColumnIndex(COLUMN_ID)))
                    .houseNo(cursor.getInt(cursor.getColumnIndex(COLUMN_HOUSE_NO)))
                    .street(cursor.getString(cursor.getColumnIndex(COLUMN_STREET)))
                    .state(cursor.getString(cursor.getColumnIndex(COLUMN_STATE)))
                    .city(cursor.getString(cursor.getColumnIndex(COLUMN_CITY)))
                    .build();
        }
    };

    public static final DeleteResolver<Address> DELETE_RESOLVER = new DefaultDeleteResolver<Address>() {
        @NonNull
        @Override
        protected DeleteQuery mapToDeleteQuery(@NonNull Address object) {
            return DeleteQuery.builder()
                    .table(TABLE)
                    .where(COLUMN_ID + " = ?")
                    .whereArgs(object.id())
                    .build();
        }
    };
}
