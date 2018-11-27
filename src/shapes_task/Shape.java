package shapes_task;

public abstract class Shape {
    protected static final double PRECISION_DELTA = 0.001;

    private final String color;

    protected Shape(String color) {
        this.color = color;
    }

    public void draw() {
        System.out.println("Shape: " + this.getClass().getSimpleName());
        System.out.println("Color: " + getColor());
        System.out.println("Area: " + getArea());
    }

    public abstract double getArea();

    public String getColor() {
        return color;
    }
}
