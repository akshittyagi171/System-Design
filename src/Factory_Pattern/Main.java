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
