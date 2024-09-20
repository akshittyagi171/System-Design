package Factory_Pattern.ShapeImpl;

import Factory_Pattern.Shape.Shape;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangle");
    }
}
