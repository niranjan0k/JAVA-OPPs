package Interface;

public class Square implements Shape {

    private float side;

    public Square(float side) {
        this.side = side;
    }

    @Override
    public float calculateArea() {
        return side * side;
    }
    
}
