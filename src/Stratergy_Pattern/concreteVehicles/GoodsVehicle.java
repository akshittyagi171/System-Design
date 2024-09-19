package Stratergy_Pattern.concreteVehicles;

import Stratergy_Pattern.DriveContext.Vehicle;
import Stratergy_Pattern.strategyImpl.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle {

    public GoodsVehicle(){
        super(new NormalDriveStrategy());
    }
}
