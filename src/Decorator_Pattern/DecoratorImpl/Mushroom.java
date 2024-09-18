package Decorator_Pattern.DecoratorImpl;

import Decorator_Pattern.Decorator.ToppingDecorator;
import Decorator_Pattern.base.BasePizza;

public class Mushroom extends ToppingDecorator {

    BasePizza basePizza;

    public Mushroom(BasePizza pizza){
        this.basePizza = pizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 50;
    }
}
