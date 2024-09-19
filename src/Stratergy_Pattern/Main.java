package Stratergy_Pattern;

import Stratergy_Pattern.concreteVehicles.GoodsVehicle;
import Stratergy_Pattern.concreteVehicles.OffRoadVehicles;
import Stratergy_Pattern.concreteVehicles.SportsVehicle;

public class Main {

    public static void main(String[] args) {

        // GoodsVehicle using NormalDriveStrategy
        GoodsVehicle goodsVehicle = new GoodsVehicle();
        System.out.println("Goods Vehicle:");
        goodsVehicle.drive();

        // OffRoadVehicles using SportsDriveStrategy
        OffRoadVehicles offRoadVehicle = new OffRoadVehicles();
        System.out.println("\nOff-Road Vehicle:");
        offRoadVehicle.drive();

        // SportsVehicle using SportsDriveStrategy
        SportsVehicle sportsVehicle = new SportsVehicle();
        System.out.println("\nSports Vehicle:");
        sportsVehicle.drive();
    }
}
