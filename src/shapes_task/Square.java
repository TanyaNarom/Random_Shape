package shapes_task;

public final class Square extends Shape {
    private final double side;

    public Square(double side, String color) {
        super(color);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("Length of the side: " + getSide());
        System.out.println("Area: " + getArea());
    }

    @Override
    public double getArea() {
        return getSide() * getSide();
    }
}
