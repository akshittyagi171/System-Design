package Stratergy_Pattern.concreteVehicles;

import Stratergy_Pattern.DriveContext.Vehicle;
import Stratergy_Pattern.strategyImpl.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {

    public SportsVehicle(){
        super(new SportsDriveStrategy());
    }
}
