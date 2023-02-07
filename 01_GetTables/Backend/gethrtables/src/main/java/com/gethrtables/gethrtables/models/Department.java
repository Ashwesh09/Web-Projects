package com.gethrtables.gethrtables.models;

public class Department {
    private int DEPARTMENT_ID;
    private String DEPARTMENT_NAME;
    private int Manager_ID;
    private int location_ID;
    public Department() {
    }
    public Department(int dEPARTMENT_ID, String dEPARTMENT_NAME, int manager_ID, int location_ID) {
        DEPARTMENT_ID = dEPARTMENT_ID;
        DEPARTMENT_NAME = dEPARTMENT_NAME;
        Manager_ID = manager_ID;
        this.location_ID = location_ID;
    }
    public int getDEPARTMENT_ID() {
        return DEPARTMENT_ID;
    }
    public void setDEPARTMENT_ID(int dEPARTMENT_ID) {
        DEPARTMENT_ID = dEPARTMENT_ID;
    }
    public String getDEPARTMENT_NAME() {
        return DEPARTMENT_NAME;
    }
    public void setDEPARTMENT_NAME(String dEPARTMENT_NAME) {
        DEPARTMENT_NAME = dEPARTMENT_NAME;
    }
    public int getManager_ID() {
        return Manager_ID;
    }
    public void setManager_ID(int manager_ID) {
        Manager_ID = manager_ID;
    }
    public int getLocation_ID() {
        return location_ID;
    }
    public void setLocation_ID(int location_ID) {
        this.location_ID = location_ID;
    }
    
    

}
