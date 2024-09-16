package Startergy_Pattern.concreteVehicles;

import Startergy_Pattern.DriveContext.Vehicle;
import Startergy_Pattern.startegyImpl.SportsDriveStrategy;

public class OffRoadVehicles extends Vehicle {

    OffRoadVehicles(){
        super(new SportsDriveStrategy());
    }
}
