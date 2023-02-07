package com.gethrtables.gethrtables.models;

public class Country {
    private String COUNTRY_ID;
    private String COUNTRY_NAME;
    private int REGION_ID;

    
    public Country(String cOUNTRY_ID, String cOUNTRY_NAME, int rEGION_ID) {
        COUNTRY_ID = cOUNTRY_ID;
        COUNTRY_NAME = cOUNTRY_NAME;
        REGION_ID = rEGION_ID;
    }
    public Country() {
    }
    public String getCOUNTRY_ID() {
        return COUNTRY_ID;
    }
    public void setCOUNTRY_ID(String cOUNTRY_ID) {
        COUNTRY_ID = cOUNTRY_ID;
    }
    public String getCOUNTRY_NAME() {
        return COUNTRY_NAME;
    }
    public void setCOUNTRY_NAME(String cOUNTRY_NAME) {
        COUNTRY_NAME = cOUNTRY_NAME;
    }
    public int getREGION_ID() {
        return REGION_ID;
    }
    public void setREGION_ID(int rEGION_ID) {
        REGION_ID = rEGION_ID;
    }


}
