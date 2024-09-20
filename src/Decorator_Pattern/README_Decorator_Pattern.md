
# Decorator Pattern - In-Depth Explanation

The **Decorator Pattern** is a structural design pattern that allows you to dynamically attach additional responsibilities to an object, enhancing its behavior. This is done by creating decorator classes that wrap the original object and modify or extend its functionality.

## Purpose
The Decorator Pattern is used to add features to objects without modifying their structure. It is especially useful when you want to add behavior to individual objects at runtime without affecting other objects of the same class.

## Key Participants in Decorator Pattern:

### 1. Base Component (BasePizza)
The **Base Component** defines the basic interface for objects that can have responsibilities added to them dynamically. In our case, `BasePizza` is the abstract class that defines the `cost()` method for calculating the pizza's price.

```java
package Decorator_Pattern.base;

public abstract class BasePizza {
    public abstract int cost();
}
```

### 2. Concrete Components (FarmHouse, Margherita, VegDelight)
These are the classes that represent the concrete instances of `BasePizza`, each having a unique cost associated with it.

#### FarmHouse Pizza
```java
package Decorator_Pattern.baseImpl;

import Decorator_Pattern.base.BasePizza;

public class FarmHouse extends BasePizza {

    @Override
    public int cost() {
        return 200;
    }
}
```

#### Margherita Pizza
```java
package Decorator_Pattern.baseImpl;

import Decorator_Pattern.base.BasePizza;

public class Margherita extends BasePizza {

    @Override
    public int cost() {
        return 100;
    }
}
```

#### VegDelight Pizza
```java
package Decorator_Pattern.baseImpl;

import Decorator_Pattern.base.BasePizza;

public class VegDelight extends BasePizza {

    @Override
    public int cost() {
        return 120;
    }
}
```

### 3. Decorator (ToppingDecorator)
The **Decorator** class inherits from `BasePizza` and contains an abstract class that holds a reference to a `BasePizza` object. It is used to add responsibilities to the pizza object dynamically.

```java
package Decorator_Pattern.Decorator;

import Decorator_Pattern.base.BasePizza;

public abstract class ToppingDecorator extends BasePizza {
}
```

### 4. Concrete Decorators (ExtraCheese, Mushroom)
The **Concrete Decorators** extend the `ToppingDecorator` and override the `cost()` method. They enhance the behavior of the base pizza by adding the cost of the toppings.

#### ExtraCheese Topping
```java
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
```

#### Mushroom Topping
```java
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
```

## Benefits of the Decorator Pattern
1. **Single Responsibility Principle**: The pattern allows you to divide the behavior between classes into smaller components, making them more maintainable and reusable.
2. **Open/Closed Principle**: Objects can be extended without modifying their original code.
3. **Flexible Combinations**: You can combine multiple decorators to create different combinations of behavior at runtime.

## Example Usage
Consider the following `Main` class, which demonstrates the creation of pizzas and how toppings can be added to them dynamically.

```java
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
```

## Output:
```
Margherita cost: 100
Margherita with Extra Cheese cost: 150
Margherita with Extra Cheese and Mushroom cost: 200
FarmHouse cost: 200
FarmHouse with Extra Cheese cost: 250
FarmHouse with Extra Cheese and Mushroom cost: 300
VegDelight cost: 120
VegDelight with Mushroom cost: 170
```

## Conclusion
The Decorator Pattern allows you to add or modify the functionality of objects dynamically at runtime. It promotes the principles of design flexibility, as different decorators can be combined to create new behaviors without modifying the original object. In this case, we've seen how different pizzas can be dynamically "decorated" with toppings like Extra Cheese and Mushroom to calculate the final cost.
