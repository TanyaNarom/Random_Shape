package shapes_task;

public final class Circle extends Shape {
    private final double radius;

    public Circle(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }


    @Override
    public void draw() {
        super.draw();
        System.out.println("Radius: " + getRadius());
        System.out.println("Area: " + getArea());
    }

    @Override
    public double getArea() {
        return Math.PI * getRadius() * getRadius();
    }
}
