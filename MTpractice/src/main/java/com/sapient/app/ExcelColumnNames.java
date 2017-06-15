package com.sapient.app;

/**
 * Created by Suraj on 3/18/2017.
 */
public enum ExcelColumnNames {
    ID("id"),
    NAME("name"),
    GENDER("gender"),
    PRIORITY("priority");


    private final String name;

    ExcelColumnNames(String name) {
        this.name= name;
    }
}
