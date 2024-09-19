package Startergy_Pattern.concreteVehicles;

import Startergy_Pattern.DriveContext.Vehicle;
import Startergy_Pattern.startegyImpl.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {

    public SportsVehicle(){
        super(new SportsDriveStrategy());
    }
}
