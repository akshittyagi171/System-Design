package Stratergy_Pattern.strategyImpl;

import Stratergy_Pattern.strategy.DriveStrategy;

public class SportsDriveStrategy implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("You are using Sports Drive Strategy");
    }
}
