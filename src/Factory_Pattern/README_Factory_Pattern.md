
# Factory Pattern - In-Depth Explanation

The **Factory Pattern** is a creational design pattern that provides an interface for creating objects in a super class, but allows subclasses to alter the type of objects that will be created. The Factory Pattern is useful when the exact types of objects that need to be created are not known beforehand.

## Purpose
The Factory Pattern is used to encapsulate the creation logic of an object so that the client code can request an object without worrying about the actual instantiation process. It promotes loose coupling by eliminating the need for the client to know about the specific class being instantiated.

## Key Participants in Factory Pattern:

### 1. Product Interface (Shape)
The **Product Interface** defines the interface that all concrete products must implement. In our case, `Shape` is the interface that defines a `draw()` method.

```java
package Factory_Pattern.Shape;

public interface Shape {
    void draw();
}
```

### 2. Concrete Products (Circle, Rectangle)
These are the specific classes that implement the `Shape` interface. Each class represents a concrete product that can be created by the factory.

#### Circle Class
```java
package Factory_Pattern.ShapeImpl;

import Factory_Pattern.Shape.Shape;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle");
    }
}
```

#### Rectangle Class
```java
package Factory_Pattern.ShapeImpl;

import Factory_Pattern.Shape.Shape;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangle");
    }
}
```

### 3. Creator (ShapeFactory)
The **Factory** class is responsible for deciding which concrete product to instantiate based on the input provided by the client. It defines a `getShape()` method that returns an instance of the `Shape` interface based on the provided input.

```java
package Factory_Pattern.Factory;

import Factory_Pattern.Shape.Shape;
import Factory_Pattern.ShapeImpl.Circle;
import Factory_Pattern.ShapeImpl.Rectangle;

public class ShapeFactory {

    public Shape getShape(String input){
        return switch (input) {
            case "CIRCLE" -> new Circle();
            case "RECTANGLE" -> new Rectangle();
            default -> null;
        };
    }
}
```

### 4. Client (Main)
The **Client** is the class that interacts with the factory to get an instance of the `Shape` interface. The client does not know or care about the concrete class it is working with; it just knows that it can invoke `draw()` on the `Shape` object.

```java
package Factory_Pattern;

import Factory_Pattern.Factory.ShapeFactory;
import Factory_Pattern.Shape.Shape;

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactoryObj = new ShapeFactory();
        Shape shapeObj = shapeFactoryObj.getShape("CIRCLE");
        shapeObj.draw();
    }
}
```

## Workflow:
1. The client (`Main`) requests a `Shape` object by calling the `getShape()` method of the `ShapeFactory` class.
2. The `ShapeFactory` takes an input string (e.g., `"CIRCLE"`) and returns the corresponding concrete class (e.g., `Circle`).
3. The client then calls the `draw()` method on the `Shape` object, which triggers the behavior specific to the concrete class.

## Benefits of the Factory Pattern
1. **Encapsulation**: The creation logic is encapsulated within the factory, simplifying client code.
2. **Loose Coupling**: The client interacts only with the `Shape` interface, not the specific implementations, making the code easier to maintain and extend.
3. **Scalability**: New concrete products can be added by simply extending the `Shape` interface and updating the factory without changing the client code.

## Example Usage
The following example demonstrates how the factory pattern works by creating different shapes:

```java
package Factory_Pattern;

import Factory_Pattern.Factory.ShapeFactory;
import Factory_Pattern.Shape.Shape;

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactoryObj = new ShapeFactory();

        // Get Circle instance and call draw method
        Shape shapeObj = shapeFactoryObj.getShape("CIRCLE");
        shapeObj.draw(); // Output: Circle

        // Get Rectangle instance and call draw method
        Shape shapeObj2 = shapeFactoryObj.getShape("RECTANGLE");
        shapeObj2.draw(); // Output: Rectangle
    }
}
```

## Output:
```
Circle
Rectangle
```

## Conclusion
The Factory Pattern is an excellent choice when you need to create objects without specifying the exact class to instantiate. It allows for flexibility and scalability in your design, making it easy to add new product types without changing the existing client code. In this case, we've seen how different `Shape` objects like `Circle` and `Rectangle` are created using a `ShapeFactory` and how the client interacts with these objects without knowing their exact types.
