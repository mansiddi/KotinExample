package com.example.kotlinhelloworld.data;

import android.os.Parcel;

import com.google.common.collect.ImmutableList;
import com.ryanharter.auto.value.parcel.TypeAdapter;

/**
 * Created by ManzarSiddique on 08-08-2017.
 */

public class ImmutableListAdapter implements TypeAdapter<ImmutableList> {
    @Override
    public ImmutableList fromParcel(Parcel in) {
        return ImmutableList.copyOf(in.readArrayList(ImmutableList.class.getClassLoader()));
    }

    @Override
    public void toParcel(ImmutableList value, Parcel dest) {
        dest.writeList(value);
    }
}

