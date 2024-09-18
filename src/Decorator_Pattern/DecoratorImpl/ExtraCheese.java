package Decorator_Pattern.DecoratorImpl;

import Decorator_Pattern.Decorator.ToppingDecorator;
import Decorator_Pattern.base.BasePizza;

public class ExtraCheese extends ToppingDecorator {

    BasePizza basePizza;

    public ExtraCheese(BasePizza pizza){
        this.basePizza = pizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 50;
    }
}
