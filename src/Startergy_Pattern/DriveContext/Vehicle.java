package Startergy_Pattern.DriveContext;

import Startergy_Pattern.strategy.DriveStrategy;

public class Vehicle {

    DriveStrategy driveObject;

    // Constructor Injection
    public Vehicle(DriveStrategy driveObj){
        this.driveObject = driveObj;
    }

    public void drive(){
        driveObject.drive();
    }
}
