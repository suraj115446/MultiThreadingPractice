package com.sapient.app;

public class ExcelSheetData {

    private long id;
    private String name;
    private boolean isMale;
    private long priority;

    public ExcelSheetData(long id, String name, boolean isMale, long priority) {
        this.id = id;
        this.name = name;
        this.isMale = isMale;
        this.priority = priority;
    }

    public ExcelSheetData() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public void setPriority(long priority) {
        this.priority = priority;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public long getPriority() {
        return priority;
    }


}
