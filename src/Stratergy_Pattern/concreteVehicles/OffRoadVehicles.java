package Stratergy_Pattern.concreteVehicles;

import Stratergy_Pattern.DriveContext.Vehicle;
import Stratergy_Pattern.strategyImpl.SportsDriveStrategy;

public class OffRoadVehicles extends Vehicle {

    public OffRoadVehicles(){
        super(new SportsDriveStrategy());
    }
}
