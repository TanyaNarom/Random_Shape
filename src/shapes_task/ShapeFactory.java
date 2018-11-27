package shapes_task;

import java.util.Random;

public class ShapeFactory {
    private static final boolean ONLY_RIGHT_TRIANGLES = true;
    private static final int SIZE_UPPER_BOUND = 20;
    private static final String[] COLORS = {"Red", "Green", "Blue", "Yellow", "Black", "Fully transparent"};

    private static final Random RND = new Random();

    //Just util static class.
    //Class Shape should not know anything about this according to the principles of inversion of control
    private ShapeFactory() {
    }

    private static double getRandomLength(int max) {
        return (double) (RND.nextInt(max) + 1);
    }

    private static double getRandomLength() {
        return getRandomLength(SIZE_UPPER_BOUND);
    }

    private static String getRandomColor() {
        return COLORS[RND.nextInt(COLORS.length)];
    }

    public static Shape getRandomInstance() {
        Shape s = null;
        switch (RND.nextInt(3)) {
            case 0:
                s = new Circle(getRandomLength(), getRandomColor());
                break;
            case 1:
                s = new Square(getRandomLength(), getRandomColor());
                break;
            case 2:
                //TODO: Implement more methods from https://en.wikipedia.org/wiki/Solution_of_triangles
                double a = getRandomLength();
                double b = getRandomLength((int) Math.floor(a));
                if (ONLY_RIGHT_TRIANGLES) {
                    double c = Math.sqrt(a * a + b * b);
                    s = new Triangle(a, b, c, getRandomColor());
                } else {
                    while (true) {
                        try {
                            //Using exception for flow control is bad, i now. But it gives an interesting random distribution.
                            s = new Triangle(a, b, getRandomLength((int) (Math.floor(a + b) + a)), getRandomColor());
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Brutforcing triangles...");
                        }
                    }
                }
        }
        return s;
    }
}
