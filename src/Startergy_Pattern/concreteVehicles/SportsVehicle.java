package Startergy_Pattern.concreteVehicles;

import Startergy_Pattern.DriveContext.Vehicle;
import Startergy_Pattern.startegyImpl.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {

    SportsVehicle(){
        super(new SportsDriveStrategy());
    }
}
