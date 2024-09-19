
# Strategy Pattern - In-Depth Explanation

The **Strategy Pattern** is a behavioral design pattern that defines a family of algorithms, encapsulates each one, 
and makes them interchangeable. The strategy pattern allows the behavior of a class to be changed at runtime by 
encapsulating behavior in separate classes and using those classes interchangeably in the context of the main object.

## Purpose
The Strategy Pattern allows selecting an algorithm's behavior during runtime instead of hardcoding it in the program. 
This helps in creating flexible and easily extendable systems, adhering to SOLID principles, especially the **Open-Closed Principle**, 
which states that software entities should be open for extension but closed for modification.

## Key Participants in Strategy Pattern:

### 1. Context (Vehicle Class)
This is the class that uses a Strategy to perform some behavior. In our case, the `Vehicle` class represents 
the context. It has a `drive()` method, but instead of implementing the logic directly, it delegates the 
responsibility to an object that implements the `DriveStrategy` interface.

The `Vehicle` class is constructed with a `DriveStrategy` object, which is the strategy that will be used 
for driving. This allows the vehicle's driving behavior to be interchangeable based on the strategy.

```java
package Stratergy_Pattern.DriveContext;

import Stratergy_Pattern.strategy.DriveStrategy;

public class Vehicle {

   DriveStrategy driveObject;

   // Constructor Injection
   public Vehicle(DriveStrategy driveObj) {
      this.driveObject = driveObj;
   }

   public void drive() {
      driveObject.drive();
   }
}
```

### 2. Strategy Interface (DriveStrategy)
This is the common interface that all concrete strategies must implement. In our case, the `DriveStrategy` 
interface is the contract that defines the `drive()` method. Any class that implements this interface must 
provide its own behavior for driving.

```java
package Stratergy_Pattern.strategy;

public interface DriveStrategy {
   public void drive();
}
```

### 3. Concrete Strategies (NormalDriveStrategy and SportsDriveStrategy)
These are the actual implementations of the `DriveStrategy` interface. Each concrete strategy provides its 
specific implementation of the `drive()` method.

In our example, `NormalDriveStrategy` represents a strategy where normal driving is implemented, and 
`SportsDriveStrategy` represents a strategy for high-performance driving.

```java
package Stratergy_Pattern.strategyImpl;

import Stratergy_Pattern.strategy.DriveStrategy;

public class NormalDriveStrategy implements DriveStrategy {
   @Override
   public void drive() {
      System.out.println("You are using Normal Drive Strategy");
   }
}

package Stratergy_Pattern.strategyImpl;

import Stratergy_Pattern.strategy.DriveStrategy;

public class SportsDriveStrategy implements DriveStrategy {
   @Override
   public void drive() {
      System.out.println("You are using Sports Drive Strategy");
   }
}
```

### 4. Concrete Context Classes (GoodsVehicle, OffRoadVehicles, SportsVehicle)
These are specific vehicle classes that use different strategies for driving. For instance, `GoodsVehicle` 
uses `NormalDriveStrategy`, while `SportsVehicle` and `OffRoadVehicles` use `SportsDriveStrategy`.

The strategy is passed to the `Vehicle` class through constructor injection, allowing each vehicle type to 
use a different driving strategy.

```java
package Stratergy_Pattern.concreteVehicles;

import Stratergy_Pattern.DriveContext.Vehicle;
import Stratergy_Pattern.strategyImpl.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle {
   GoodsVehicle() {
      super(new NormalDriveStrategy());
   }
}

package Stratergy_Pattern.concreteVehicles;

import Stratergy_Pattern.DriveContext.Vehicle;
import Stratergy_Pattern.strategyImpl.SportsDriveStrategy;

public class OffRoadVehicles extends Vehicle {
   OffRoadVehicles() {
      super(new SportsDriveStrategy());
   }
}

package Stratergy_Pattern.concreteVehicles;

import Stratergy_Pattern.DriveContext.Vehicle;
import Stratergy_Pattern.strategyImpl.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {
   SportsVehicle() {
      super(new SportsDriveStrategy());
   }
}
```

## Benefits of the Strategy Pattern
1. **Open-Closed Principle**: You can easily introduce new strategies without modifying the context or the other strategies.
2. **Separation of Concerns**: The logic for each type of behavior is encapsulated in its own class. The context 
   class doesn't need to know the implementation details of the strategies.
3. **Dynamic Behavior**: The strategy pattern allows the behavior of the context to change at runtime, providing flexibility.
4. **Code Reusability**: Similar algorithms or behaviors are encapsulated in separate classes, promoting reusability.

## Example Usage
Consider the following main class, which creates different vehicle objects and uses their respective strategies:

```java
package Stratergy_Pattern;

import Stratergy_Pattern.concreteVehicles.GoodsVehicle;
import Stratergy_Pattern.concreteVehicles.OffRoadVehicles;
import Stratergy_Pattern.concreteVehicles.SportsVehicle;

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
```

## Output:
```
Goods Vehicle:
You are using Normal Drive Strategy

Off-Road Vehicle:
You are using Sports Drive Strategy

Sports Vehicle:
You are using Sports Drive Strategy
```

## Conclusion
The Strategy Pattern provides a flexible way to define different behaviors and swap them out as needed. It allows your application 
to be open for extension but closed for modification, ensuring adherence to clean coding practices. By using this pattern, you can 
easily add new driving strategies (e.g., `EcoDriveStrategy`, `AggressiveDriveStrategy`) without changing the `Vehicle` class or 
existing strategy implementations.
