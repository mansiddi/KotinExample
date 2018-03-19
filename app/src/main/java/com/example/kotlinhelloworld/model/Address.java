package com.example.kotlinhelloworld.model;

import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.auto.value.AutoValue;

/**
 * Created by ManzarSiddique on 07-08-2017.
 */

@AutoValue
public abstract class Address implements Parcelable {
    public abstract String id();
    public abstract int houseNo();
    public abstract String street();
    public abstract String city();
    public abstract String state();

    public Builder toBuilder() {
        return new AutoValue_Address.Builder(this);
    }



    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(String value);
        public abstract Builder houseNo(int value);
        public abstract Builder street(String value);
        public abstract Builder city(@Nullable String value);
        public abstract Builder state(String value);

        public abstract Address build();
    }

    public static Builder builder(){
        return new AutoValue_Address.Builder();
    }

    public String displayName() {
        return street() + ", " + city();
    }
}
