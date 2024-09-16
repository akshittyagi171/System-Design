package Startergy_Pattern.startegyImpl;

import Startergy_Pattern.strategy.DriveStrategy;

public class NormalDriveStrategy implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("You are using Normal Drive Strategy");
    }
}
