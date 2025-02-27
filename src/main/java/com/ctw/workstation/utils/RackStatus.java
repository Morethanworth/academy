package com.ctw.workstation.utils;
public enum RackStatus {

    AVAILABLE("AVAILABLE"), UNAVAILABLE("UNAVAILABLE"), BOOKED("BOOKED");

    private final String name;

    RackStatus(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static RackStatus getByValue(String value){
        for(RackStatus status : RackStatus.values()){
            if(status.getName().equalsIgnoreCase(value)){
                return status;
            }
        }

        throw new IllegalArgumentException("The status " + value + " is not valid.");
    }
}