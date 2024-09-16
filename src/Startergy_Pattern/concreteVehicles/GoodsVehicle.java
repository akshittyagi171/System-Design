package Startergy_Pattern.concreteVehicles;

import Startergy_Pattern.DriveContext.Vehicle;
import Startergy_Pattern.startegyImpl.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle {

    GoodsVehicle(){
        super(new NormalDriveStrategy());
    }
}
