package Startergy_Pattern;

import Startergy_Pattern.concreteVehicles.GoodsVehicle;
import Startergy_Pattern.concreteVehicles.OffRoadVehicles;
import Startergy_Pattern.concreteVehicles.SportsVehicle;

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
