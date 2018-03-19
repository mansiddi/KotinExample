package com.example.kotlinhelloworld.model;

/**
 * Created by ManzarSiddique on 07-08-2017.
 */

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.example.kotlinhelloworld.data.ImmutableListAdapter;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import com.ryanharter.auto.value.parcel.ParcelAdapter;

import java.util.List;

@AutoValue
public abstract class User implements Parcelable {
    public abstract String id();
    @ParcelAdapter(ImmutableListAdapter.class)
    public abstract ImmutableList<Address> address();
    public abstract String firstName();
    public abstract String lastName();
    public abstract String gender();
    public abstract boolean isMarried();
//    public abstract Date dob();

    public Builder toBuilder() {
        return new AutoValue_User.Builder(this);
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(String value);

        public abstract Builder address(List<Address> value);

        abstract ImmutableList.Builder<Address> addressBuilder();
        public Builder addAddress(Address value) {
            addressBuilder().add(value);
            return this;
        }

        public abstract Builder firstName(String value);
        public abstract Builder gender(@Nullable String value);
        public abstract Builder lastName(String value);
        public abstract Builder isMarried(boolean value);
//        public abstract Builder dob(Date value);

        public abstract User build();
    }

    public static Builder builder(){
        return new AutoValue_User.Builder();
    }

    public String displayName() {
        return firstName() + ", " + lastName();
    }
}
