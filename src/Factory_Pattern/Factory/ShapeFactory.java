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
