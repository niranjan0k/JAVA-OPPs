package Interface;

public class Main {
    public static void main(String[] args) {
        Shape.printArea(12F);

        Square square = new Square(4.0f);
        square.printShapeType("Square");
        System.out.println("Area of square is : " + square.calculateArea());
    }
}
