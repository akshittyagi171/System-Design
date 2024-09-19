package Decorator_Pattern;

import Decorator_Pattern.base.BasePizza;
import Decorator_Pattern.baseImpl.FarmHouse;
import Decorator_Pattern.baseImpl.Margherita;
import Decorator_Pattern.baseImpl.VegDelight;
import Decorator_Pattern.DecoratorImpl.ExtraCheese;
import Decorator_Pattern.DecoratorImpl.Mushroom;

public class Main {

    public static void main(String[] args) {

        // Base Pizza: Margherita
        BasePizza margherita = new Margherita();
        System.out.println("Margherita cost: " + margherita.cost());

        // Margherita with Extra Cheese
        BasePizza margheritaWithCheese = new ExtraCheese(margherita);
        System.out.println("Margherita with Extra Cheese cost: " + margheritaWithCheese.cost());

        // Margherita with Extra Cheese and Mushroom
        BasePizza margheritaWithCheeseAndMushroom = new Mushroom(margheritaWithCheese);
        System.out.println("Margherita with Extra Cheese and Mushroom cost: " + margheritaWithCheeseAndMushroom.cost());

        // Base Pizza: FarmHouse
        BasePizza farmHouse = new FarmHouse();
        System.out.println("FarmHouse cost: " + farmHouse.cost());

        // FarmHouse with Extra Cheese
        BasePizza farmHouseWithCheese = new ExtraCheese(farmHouse);
        System.out.println("FarmHouse with Extra Cheese cost: " + farmHouseWithCheese.cost());

        // FarmHouse with Extra Cheese and Mushroom
        BasePizza farmHouseWithCheeseAndMushroom = new Mushroom(farmHouseWithCheese);
        System.out.println("FarmHouse with Extra Cheese and Mushroom cost: " + farmHouseWithCheeseAndMushroom.cost());

        // Base Pizza: VegDelight
        BasePizza vegDelight = new VegDelight();
        System.out.println("VegDelight cost: " + vegDelight.cost());

        // VegDelight with Mushroom
        BasePizza vegDelightWithMushroom = new Mushroom(vegDelight);
        System.out.println("VegDelight with Mushroom cost: " + vegDelightWithMushroom.cost());
    }
}
