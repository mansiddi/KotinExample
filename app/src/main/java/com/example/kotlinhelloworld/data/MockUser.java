package com.example.kotlinhelloworld.data;

import com.example.kotlinhelloworld.model.Address;
import com.example.kotlinhelloworld.model.User;

public final class MockUser {
    public static final User ONE = User.builder()
            .id("1001")
            .addAddress(Address.builder()
                    .id("101")
                    .houseNo(100)
                    .street("x-b-/12 ABC")
                    .city("Kolkata")
                    .state("W.B")
                    .build())
            .addAddress(Address.builder()
                    .id("102")
                    .houseNo(101)
                    .street("x-b-/13 ABC")
                    .city("Kolkata")
                    .state("W.B")
                    .build())
            .firstName("Manzar")
            .lastName("Siddique")
            .gender("Male")
            .isMarried(true)
//            .dob(new Date("1988-15-03T12:34:14.000"))
            .build();

    public static final User TWO = User.builder()
            .id("1002")
            .addAddress(Address.builder()
                    .id("103")
                    .houseNo(100)
                    .street("x-b-/12 ABC")
                    .city("Kolkata")
                    .state("W.B")
                    .build())
            .addAddress(Address.builder()
                    .id("104")
                    .houseNo(101)
                    .street("x-b-/13 ABC")
                    .city("Kolkata")
                    .state("W.B")
                    .build())
            .firstName("Manzar")
            .lastName("Siddique")
            .gender("Male")
            .isMarried(true)
//            .dob(new Date("1988-15-03T12:34:14.000"))
            .build();
}
