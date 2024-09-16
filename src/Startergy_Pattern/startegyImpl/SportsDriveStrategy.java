package Startergy_Pattern.startegyImpl;

import Startergy_Pattern.strategy.DriveStrategy;

public class SportsDriveStrategy implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("You are using Sports Drive Strategy");
    }
}
