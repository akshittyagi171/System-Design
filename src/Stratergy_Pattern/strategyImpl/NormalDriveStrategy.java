package Stratergy_Pattern.strategyImpl;

import Stratergy_Pattern.strategy.DriveStrategy;

public class NormalDriveStrategy implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("You are using Normal Drive Strategy");
    }
}
