package Startergy_Pattern.concreteVehicles;

import Startergy_Pattern.DriveContext.Vehicle;
import Startergy_Pattern.startegyImpl.SportsDriveStrategy;

public class OffRoadVehicles extends Vehicle {

    public OffRoadVehicles(){
        super(new SportsDriveStrategy());
    }
}
