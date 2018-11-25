package shapes_task;

import java.util.Random;

public class Main {
    final static Random RNG = new Random();
    final static int MAX_SHAPES_COUNT_BOUND = 50;

    public static void main(String[] args) {
        int shapesCount = RNG.nextInt(MAX_SHAPES_COUNT_BOUND) + 1;
        Shape[] shapesContainer = new Shape[shapesCount];
        for (int i = 0; i < shapesCount; i++) {
            shapesContainer[i] = ShapeFactory.getRandomInstance();
        }

        for (Shape s : shapesContainer) {
            s.draw();
            System.out.println("====================");
        }
    }
}
