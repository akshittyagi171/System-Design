package Decorator_Pattern.baseImpl;

import Decorator_Pattern.base.BasePizza;

public class VegDelight extends BasePizza {

    @Override
    public int cost() {
        return 120;
    }
}
