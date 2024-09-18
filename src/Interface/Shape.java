package Interface;

public interface Shape {
    float calculateArea();
    
    static void printArea(float area){
        float result = area * area;
        System.out.println("Calculate Area: " + result);
    }

    default void printShapeType(String type){
        System.out.println("The shape is : " + type);
    }
}

